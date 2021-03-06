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

public class SparkApp2Main {
    public static String SPACE_DELIMITER = ",";

    public static void main(String[] args) throws IOException {
        SparkSession spark = SparkSession.builder()
            .master("local[*]")
            .appName("Job2")
            .getOrCreate();
        
        // activate Spline Lineage
        SparkLineageInitializer.enableLineageTracking(spark);

        System.out.println("########################### Copying data from source to target");
        spark.read()
            .option("header", "true")
            .option("inferSchema", "true")
            .csv("/root/project/nationalparks_copy.csv")
            .as("source")
            .coalesce(1)
            .write()
            .mode(SaveMode.Overwrite)
            .csv("/root/project2/nationalparks_copy2.csv");
        System.out.println("########################### Copying - output file created /root/project2/nationalparks_copy2.csv");

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
            .csv("/root/project/utah_parks.csv");
        System.out.println("########################### Input file : " + df.count() + " lines");
            
        Dataset<Row> dfResult = df.groupBy("Location")
            .agg(sum("Area"), count("Location"));

        dfResult.coalesce(1).write()
            .mode(SaveMode.Overwrite)
            .csv("/root/project2/agg_parks_utah.csv"); 
        System.out.println("########################### Parks agregated in /root/project2/agg_parks_utah.csv");
    }
}