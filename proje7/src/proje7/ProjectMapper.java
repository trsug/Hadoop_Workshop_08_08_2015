package proje7;

import java.io.IOException;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class ProjectMapper extends
		Mapper<LongWritable, Text, Text, DoubleWritable> {

	@Override
	public void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {

		String line = value.toString();

		String[] parts = line.split("\\|");

		if (!parts[5].equals("null")) {

			Double duration = Double.parseDouble(parts[5]);

			context.write(new Text("duration"), new DoubleWritable(duration));
		}
	}
}
