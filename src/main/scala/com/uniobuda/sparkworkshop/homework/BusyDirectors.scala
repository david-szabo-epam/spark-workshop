package com.uniobuda.sparkworkshop.homework

import org.apache.spark.sql.{Encoders, SparkSession}
import org.apache.spark.sql.functions._

object BusyDirectors {

  def process(spark: SparkSession): Unit = {
    implicit val encoder = Encoders.product[Crew]
    val schema = encoder.schema

    /*
     * Use the Dataset API.
     * How many directors have directed more than 50 movies?
     * Show the result as a single number.
     *
     * Hint: you have to use the schema defined above when reading the file so that types match the Crew case class
     */


  }
}
