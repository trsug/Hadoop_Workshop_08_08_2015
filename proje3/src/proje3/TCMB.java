package proje3;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class TCMB {
	
	public static void main(String[] args) throws Exception {
		if (args.length != 2) {
			System.err.println("Kullanım: TCMB <girdi> <çıktı>");
			System.exit(-1);
		}

		Job job = Job.getInstance();
		job.setJarByClass(TCMB.class);
		job.setJobName("TCMB");
		

		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));

		job.setMapperClass(TCMBMapper.class);
		job.setReducerClass(TCMBReducer.class);

		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(DoubleWritable.class);

		System.exit(job.waitForCompletion(true) ? 0 : 1);
	}
}
