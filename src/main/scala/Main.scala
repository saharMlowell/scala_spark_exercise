package exercise

import org.apache.spark.sql.SparkSession

object Exercise extends App{
  val spark = SparkSession.builder().master("local").appName("scala_spark_exercise").getOrCreate

  import spark.implicits._ // This import is needed to use the $-notation

  val df = spark.read.json("src/main/resources/people.json")
  df.write.parquet("src/main/resources/people.parquet") // DataFrames can be saved as Parquet files, maintaining the schema information

  // Read in the parquet file created above
  // Parquet files are self-describing so the schema is preserved
  // The result of loading a Parquet file is also a DataFrame
  val parquetDf = spark.read.parquet("src/main/resources/people.parquet")

  parquetDf.filter($"age" > 21).select("name").show() // Select name of people older than 21

}