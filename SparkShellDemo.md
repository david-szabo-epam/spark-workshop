# Spark shell demo

## Basics

### RDD

```scala
// Create a regular list on the Driver
val list = (0 to 99).toList

// Distribute it to the workers
val rdd = sc.parallelize(list)

// Check Partition size
rdd.partitions.size

// Filter RDD
val evens = rdd.filter(n => n % 2 == 0)

// Check UI - nothing happened

// Collect
evens.collect

// Check UI again - DAG Visualization
```

### Dataframe & Dataset

```scala

// Create DataFrame from List
val numbersDF = (0 to 99).toDF

// Filter with column methods
val evenNumbersDF = numbersDF.filter(col("value").mod(2).equalTo(0))

// Collect
evenNumbersDF.collect

// Table like representation (only 20 results)
evenNumbersDF.show

// Filter using expression
val evenNumbersExpDF = numbersDF.filter("value % 2 = 0")

evenNumbersExpDF.collect

// Create Dataset from DataFrame
val numbersDS = numbersDF.as[Int]

// Filter using expression
val evenNumbersDS = numbersDS.filter("value % 2 = 0")

evenNumbersDS.collect

// Filter using lambda
val evenNumbersLambdaDS = numbersDS.filter(v => v % 2 == 0)

evenNumbersLambdaDS.collect

```
> **NOTE:** To run the following code samples you will need the [persons.json](persons.json) file from this repository placed in the location you are running the spark-shell.

## Structured data

```scala

// Use Datasource API to read json file
val personsDF = spark.read.json("persons.json")

// Filter and project
val namesDF = personsDF.where("age > 35").select("name.first", "name.last")

namesDF.show()

//Define case classes - use :paste
case class PersonName(
    first: String,
    last: String
)

case class Person(
    name: PersonName,
    age: Long
)

// Create dataset and do the same using lambdas
val personsDS = personsDF.as[Person]

val namesDS = personsDS.filter(_.age > 35).map(p => (p.name.first, p.name.last))

namesDS.show()

// Open the UI and check the execution for both cases in the SQL tab
```

## Schema inference

```scala
val people = spark.read.json("persons.json")

people.printSchema

import org.apache.spark.sql.types._
	
val manualSchema = StructType(Array(
	StructField("name",
		StructType(Array(
			StructField("first", StringType),
			StructField("last", StringType)))),
	StructField("age", IntegerType)
))

val peopleSchema = spark.read
	.format("json")
	.schema(manualSchema)
	.load("persons.json")
	

peopleSchema.printSchema
```

## SQL API
```scala
personsDF.createOrReplaceTempView("persons")

val namesSql = spark.sql("select name.first, name.last FROM persons WHERE age > 35")

namesSql.collect

namesDF.collect

//check UI SQL - compare the execution plans
```
