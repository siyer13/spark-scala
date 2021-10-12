package org.enquero

import com.typesafe.scalalogging.Logger
import org.apache.spark.sql.SparkSession
import org.slf4j.LoggerFactory

import java.io.{ InputStream}
import java.util.Properties


object SparkSessionTest extends App  {

  val logger = LoggerFactory.getLogger(getClass.getSimpleName)
  val spark = SparkSession.builder()
    .master("local[1]")
    .appName("SparkByExample")
    .getOrCreate();

  println("First SparkContext:")
  logger.info(s"This is a log message siyer")
  println("APP Name :"+spark.sparkContext.appName);
  println("Deploy Mode :"+spark.sparkContext.deployMode);
  println("Master :"+spark.sparkContext.master);


  val is: InputStream = ClassLoader.getSystemResourceAsStream("dev/application.properties")
  val properties: Properties = new Properties()
  properties.load(is)
  println(properties.getProperty("app_name"))
  println(properties.getProperty("env"))

  import jobs.mRR

  mRR.configTest()


}
