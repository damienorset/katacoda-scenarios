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
            .appName("Job1")
            .getOrCreate();
        
        // activate Spline Lineage
        SparkLineageInitializer.enableLineageTracking(spark);

        System.out.println("########################### Copying data from source to target");
        spark.read()
            .option("header", "true")
            .option("inferSchema", "true")
            .csv("/tmp/nationalparks.csv")
            .as("source")
            .coalesce(1)
            .write()
            .mode(SaveMode.Overwrite)
            .csv("/root/project/nationalparks_copy.csv");
        System.out.println("########################### Copying - output file created /root/project/nationalparks_copy.csv");

        StructType schema = new StructType()
            .add("Name", "string")
            .add("Location", "string")
            .add("Year", "int")
            .add("Area", "double");
        
        System.out.println("########################### Reading input file");
        Dataset<Row> df = spark.read()
            .option("header", "true")
            //.option("inferSchema", "true")
            .schema(schema)
            .csv("/tmp/nationalparks.csv");
        System.out.println("########################### Input file : " + df.count() + " lines");
            
        Dataset<Row> utah = df.filter("Location = 'Utah'");
        System.out.println("########################### Number of parks in Utah = " + utah.count());
        utah.coalesce(1).write()
            .mode(SaveMode.Overwrite)
            .csv("/root/project/utah_parks.csv"); 
        
        Dataset<Row> dfResult = df.groupBy("Location")
            .agg(sum("Area"), count("Location"));

        dfResult.coalesce(1).write()
            .mode(SaveMode.Overwrite)
            .csv("/root/project/agg_parks.csv"); 
        System.out.println("########################### Parks agregated in /root/project/agg_parks.csv");
    }
}