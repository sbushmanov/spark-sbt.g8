package $organization$

import org.apache.spark.sql.{DataFrame, Dataset}
import org.apache.spark.sql.{functions => F}

package object $name$ {

  //  Define constants
  val hello = "Let's get started"
  
  // Define implicits
  implicit class ToUpper(s: String) {
    def toUpper: String = s.toUpperCase    
  }
  
  implicit class ToInt(b: Boolean) {
    def toInt = if(b) 1 else 0
  }
  
  implicit class StatsToLong(df: DataFrame) {
    def statsToLong: DataFrame = {
        val dfSummary = df.describe()
        import dfSummary.sparkSession.implicits._

        val cols = df.columns
        val longDf = dfSummary.flatMap{ row =>
            (1 until row.size).map{ i =>
                (row.getAs[String](0), cols(i), row.getAs[String](i).toDouble)
        }}.toDF("stat","col","value")
        longDf.
        groupBy("col").
        pivot("stat",Seq("count","mean")).
        agg(F.first("value"))
	    }
	}
}


