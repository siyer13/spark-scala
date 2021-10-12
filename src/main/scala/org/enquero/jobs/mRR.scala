package org.enquero.jobs

object mRR {

  import com.typesafe.config.ConfigFactory

  def configTest(): Unit = {
    val config = ConfigFactory.load("org/enquero/jobs/mRR.conf")
    println(config.getString("mRR.table_name"))

  }
}
