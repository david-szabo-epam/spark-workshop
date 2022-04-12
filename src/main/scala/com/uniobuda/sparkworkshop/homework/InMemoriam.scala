package com.uniobuda.sparkworkshop.homework

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object InMemoriam {

  def process(spark: SparkSession): Unit = {
    val userHome = System.getProperty("user.home")
    val outputFolderName = s"$userHome/homework/in_memoriam"

    /*
     * Bonus exercise
     *
     * Create a single text output file with the list of people who have died in 2020 in the following format:
     * Kirk Douglas 1916-2020
     * Sean Connery 1930-2020
     *
     * Consider only people whose birth year is known.
     * Use whichever API you prefer.
     */


  }
}
