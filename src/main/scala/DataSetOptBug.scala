import org.apache.spark.SparkContext
import org.apache.spark.sql.{Dataset, SQLContext, SparkSession}

object DataSetOptBug {

  def main(args: Array[String]): Unit = {
    if (System.getProperty("spark.master") == null) System.setProperty("spark.master", "local[*]")
    val sparkSession: SparkSession = SparkSession.builder.appName("Bug Context").getOrCreate
    val sqlContext: SQLContext = sparkSession.sqlContext
    val sparkContext: SparkContext = sparkSession.sparkContext
    import sqlContext.implicits._
    val data: Dataset[Long] = sparkContext.range(1, 1000).toDS
    val count = data.map(i => if (i < 500) {
      Some(DataRow(i.toInt, s"i$i"))
    }
    else {
      Option.empty
    }
    ).filter(_.isEmpty).count()
    println(s"count = $count")
  }

  case class DataRow(id: Int, value: String)

}
