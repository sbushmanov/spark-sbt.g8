
import org.apache.spark.graphx._
import org.apache.spark.sql.{DataFrame, Dataset, SparkSession}
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.{functions => F}

lazy val spark = SparkSession.builder()
    .master("local[8]")
    .appName("MyApp")
    .config("spark.serializer", "org.apache.spark.serializer.KryoSerializer")
    .config("spark.hadoop.fs.defaultFS", "hdfs://localhost:9000")
    .config("spark.sql.warehouse.dir", "hdfs:///user/hive/warehouse")
    .config("hive.metastore.uris", "thrift://localhost:9083")
    .enableHiveSupport()
    .getOrCreate()
    
lazy val sc = spark.sparkContext

sc.version
scala.util.Properties.versionString


