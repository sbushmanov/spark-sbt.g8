package $package$

import org.apache.spark.sql.Column
import org.apache.spark.sql.functions._

object Functions {

  def isEven(col: Column): Column = {
    col % 2 === lit(0)
  }
  
  def toUpper(s: String): String = s.toUpperCase 

}

