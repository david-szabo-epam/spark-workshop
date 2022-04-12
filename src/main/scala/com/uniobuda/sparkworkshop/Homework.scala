package com.uniobuda.sparkworkshop

import com.uniobuda.sparkworkshop.homework.{AverageMovieLength, BusyDirectors, Genres, InMemoriam, MoviesByYear}
import org.apache.spark.sql.SparkSession

import scala.io.StdIn

object Homework extends App {
//  System.setProperty("hadoop.home.dir", "C:\\hadoop")

  val spark = SparkSession.builder()
    .master("local[*]")
    .appName("FrameApp")
    .config("spark.sql.shuffle.partitions", "3")
    .getOrCreate()

  var choice = Char.MinValue
  do {
    choice = getChoice
    executeChoice(choice)
  } while (choice != '0')

  spark.close()

  private def getChoice: Char = {
    println(
      """
        |Please enter your choice:
        | 1 - Movies By Year (DataFrame)
        | 2 - Average Movie Length (SQL)
        | 3 - Busy Directors (Dataset)
        | 4 - Genres (DataFrame)
        | 5 - Bonus: In Memoriam
        | 0 - exit
        |""".stripMargin)
    StdIn.readChar()
  }

  private def executeChoice(choice: Char): Unit =
    choice match {
      case '1' => MoviesByYear.process(spark)
      case '2' => AverageMovieLength.process(spark)
      case '3' => BusyDirectors.process(spark)
      case '4' => Genres.process(spark)
      case '5' => InMemoriam.process(spark)
      case '0' => println("Bye!")
      case _ => println("ERROR: Unknown input")
    }
}
