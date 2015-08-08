package proje3;

import java.io.IOException;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class TCMBMapper extends Mapper<LongWritable, Text, Text, DoubleWritable> {

	@Override
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

		String line = value.toString();
		String year = line.substring(6, 10);
		String tempGbpA;
		Double gbpA;

		tempGbpA = line.substring(13, 25);
		gbpA = Double.parseDouble(tempGbpA);

		context.write(new Text(year), new DoubleWritable(gbpA));

	}
}
