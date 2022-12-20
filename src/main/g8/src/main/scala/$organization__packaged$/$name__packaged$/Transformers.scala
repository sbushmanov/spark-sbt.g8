package $package$

import org.apache.spark.sql.{DataFrame, Dataset}
import org.apache.spark.sql.functions._

object Transformers {

  def happyData()(df: DataFrame): DataFrame = {
    df.withColumn("happy", lit("data is fun"))
  }

}
