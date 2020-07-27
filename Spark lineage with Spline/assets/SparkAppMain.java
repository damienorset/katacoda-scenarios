import java.io.IOException;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.types.StructType;
import static org.apache.spark.sql.functions.count;
import static org.apache.spark.sql.functions.sum;
import org.apache.spark.sql.SaveMode;
import za.co.absa.spline.harvester.SparkLineageInitializer;

public class SparkAppMain {
    public static String SPACE_DELIMITER = ",";

    public static void main(String[] args) throws IOException {
        SparkSession spark = SparkSession.builder()
            .master("local[*]")
            .appName("Lab")
            .getOrCreate();
        
        // activate Spline Lineage
        SparkLineageInitializer.enableLineageTracking(spark);

        /*JavaSparkContext sparkContext = new JavaSparkContext(spark.sparkContext());

        JavaRDD<String> stringJavaRDD = sparkContext.textFile("/tmp/nationalparks.csv");
        System.out.println("########################### Number of lines in file = " + stringJavaRDD.count());*/

        spark.read()
            .option("header", "true")
            .option("inferSchema", "true")
            .csv("/tmp/nationalparks.csv")
            .as("source")
            .write()
            .mode(SaveMode.Overwrite)
            .csv("/tmp/java-sample.csv");
        System.out.println("########################### file created /tmp/java-sample.csv");

        //JavaRDD<String> inputRDD = spark.read().flatMap(s -> Arrays.asList(s.split(SPACE_DELIMITER)).iterator());
        StructType schema = new StructType()
            .add("Name", "string")
            .add("Location", "string")
            .add("Year", "int")
            .add("Area", "long");
            
        Dataset<Row> df = spark.read()
            .option("header", "true")
            //.option("inferSchema", "true")
            .schema(schema)
            .csv("/tmp/nationalparks.csv");
            
        //Dataset<Row> utah = df.filter(s -> s.contains("Utah"));
        //System.out.println("########################### Number of parks in Utah = " + utahRDD.count());
        
        Dataset<Row> dfResult = df.groupBy("Location")
            .agg(sum("Area"), count("Name"));
        System.out.println("########################### Result = " + dfResult);

        dfResult.write()
            .mode(SaveMode.Overwrite)
            .csv("/tmp/agg_parks.csv"); 
    }
}