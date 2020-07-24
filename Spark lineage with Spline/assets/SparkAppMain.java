import java.io.IOException;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.SaveMode;
import za.co.absa.spline.harvester.SparkLineageInitializer;

public class SparkAppMain {
    public static void main(String[] args) throws IOException {
        SparkSession spark = SparkSession.builder()
            .master("local[*]")
            .appName("Lab")
            .getOrCreate();
        SparkLineageInitializer.enableLineageTracking(spark);

        JavaSparkContext sparkContext = new JavaSparkContext(spark.sparkContext());

        /*SparkConf sparkConf = new SparkConf()
                .setAppName("Example Spark App")
                .setMaster("local[*]")  // Delete this line when submitting to a cluster

        JavaSparkContext sparkContext = new JavaSparkContext(sparkConf);*/
        JavaRDD<String> stringJavaRDD = sparkContext.textFile("/tmp/nationalparks.csv");
        System.out.println("########################### Number of lines in file = " + stringJavaRDD.count());


        spark.read()
            .option("header", "true")
            .option("inferSchema", "true")
            .csv("/tmp/nationalparks.csv")
            .as("source")
            .write()
            .mode(SaveMode.Overwrite)
            .csv("/tmp/java-sample.csv");
        System.out.println("########################### file created /tmp/java-sample.csv");
        
    }
}