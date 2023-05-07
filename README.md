# Spark Workshop

This repository contains the Spark demo associated with an introductory Spark presentation.

## System Requirements

This workshop uses two approaches for running Spark:
* The command line interface `spark-shell`
* The embedded Spark in the Scala SBT application.

## Running Spark from the command line

Open a terminal window and start the spark console:

```bash
# Start Spark Shell
spark-shell
```

Find the address of the Spark context Web UI in the output lines 
and open it in a browser (It should be something like http://10.0.2.15:4040).

Open the [Spark shell demo](./SparkShellDemo.md) documentation.

For some of the examples to run successfully you will need files from this repository and place them in the fodler where you executed Spark.

## Run the Scala code

* Start IntelliJ
* File menu > New > Project from Version control...
* Provide the url from github
* Set Directory to where you want to download the files on your loval machine
* Run Program.scala

Note the URL of the Spark UI, and open it in a browser.

## Homework

Display the top 10 countries by number of Nobel laureates in Physics.
* Output columns: Country code, country name, number of laureates
* Use all 3 approaches: DataFrame, DataSet, SparkSQL
