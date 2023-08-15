package $package$

import org.apache.spark.sql.SparkSession
import org.apache.spark.SparkContext

trait SparkSessionBuilder extends Serializable {

  lazy val spark: SparkSession = SparkSession.builder()
    .master("local[8]")
    .appName("MyApp")
    .config("spark.serializer", "org.apache.spark.serializer.KryoSerializer")
    .config("spark.hadoop.fs.defaultFS", "hdfs://localhost:9000")
    .config("spark.sql.warehouse.dir", "hdfs:///user/hive/warehouse")
    .config("hive.metastore.uris", "thrift://localhost:9083")
    .enableHiveSupport()
    .getOrCreate()
    
  lazy val sc: SparkContext = spark.sparkContext

}
