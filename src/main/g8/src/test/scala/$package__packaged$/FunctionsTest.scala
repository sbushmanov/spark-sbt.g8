package $package$

import org.scalatest.funspec.AnyFunSpec
import org.apache.spark.sql.functions._
import com.github.mrpowers.spark.fast.tests.ColumnComparer
import org.apache.spark.sql.types.{StructField, StructType, StringType}
import org.apache.spark.sql.Row

import Functions._

class FunctionsTest
    extends AnyFunSpec
    with SparkSessionTestWrapper
    with ColumnComparer {

  import spark.implicits._

  describe("isEven") {

    it("returns true if the number is even and false otherwise") {

      val data = Seq(
        (1, false),
        (2, true),
        (3, false)
      )

      val df = data
        .toDF("some_num", "expected")
        .withColumn("actual", isEven(col("some_num")))

      assertColumnEquality(df, "actual", "expected")

    }

  }

}

