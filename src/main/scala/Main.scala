package exercise

import org.apache.spark.sql.SparkSession

object Exercise extends App{
  println("Hello World!")
  val spark = SparkSession.builder.appName("scala_spark_exercise").getOrCreate
}