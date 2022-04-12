package com.uniobuda.sparkworkshop.homework

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object MoviesByYear {

  def process(spark: SparkSession): Unit = {
    val userHome = System.getProperty("user.home")
    val outputFolderName = s"$userHome/homework/movies"

    /*
     * Use the DataFrame API.
     * Count how many movies were created each year. The results should be sorted by year.
     * Write the results into a single csv file with a header.
     */


  }
}
