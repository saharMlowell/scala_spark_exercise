package exercise

import org.apache.spark.sql.SparkSession

object Exercise extends App{
  println("Hello World!")
  val spark = SparkSession.builder().master("local").appName("scala_spark_exercise").getOrCreate
  val df = spark.read.json("src/main/resources/people.json")
  df.select("name").show()
  df.filter($"age" > 21).show()
  // Displays the content of the DataFrame to stdout
  df.show()
}