package exercise

import org.apache.spark.sql.SparkSession

object Exercise extends App{
  val spark = SparkSession.builder().master("local").appName("scala_spark_exercise").getOrCreate

  import spark.implicits._ // This import is needed to use the $-notation

  val df = spark.read.json("src/main/resources/people.json")
  df.filter($"age" > 21).select("name").show() // Select name of people older than 21

}