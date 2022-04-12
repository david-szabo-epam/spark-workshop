package com.uniobuda.sparkworkshop.homework

case class Crew(
                 _id: String,
                 name: String,
                 birthYear: Option[Int],
                 deathYear: Option[Int],
                 directed: Array[String],
                 written: Array[String]
               )
