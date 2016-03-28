package sample.spark;

import java.io.File;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.rdd.RDD;

/**
 * @author <a href="mailto:yyamada@redhat.com">Yoshikazu YAMADA</a>
 * @since Mar 15, 2016
 */
public class SparkDaoBean {

	public static void main(String[] args) {
		File file = new File("./src/main/resources/dev");
		System.setProperty("HADOOP_CONF_DIR", file.getAbsolutePath());
		System.setProperty("HADOOP_USER_NAME", "hdfs");
		SparkConf conf = new SparkConf().setAppName("Spark");
//		conf.set("spark.yarn.jar", "hdfs:///user/spark/share/lib/spark-assembly.jar");
		conf.set("spark.yarn.jar", "hdfs:///user/spark/share/lib/spark-assembly-1.5.2-hadoop2.6.0.jar");
		conf.setMaster("yarn-client");
		SparkContext context = new SparkContext(conf);
		RDD<String> rdd = context.textFile("/stream/sample.tsv", 1);
		System.out.println(rdd.count());
		System.out.println("AAAAAAAAAAAAAAAAAA");
	}

}
