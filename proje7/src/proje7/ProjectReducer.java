package proje7;

import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class ProjectReducer extends
		Reducer<Text, DoubleWritable, Text, DoubleWritable> {

	@Override
	public void reduce(Text key, Iterable<DoubleWritable> values,
			Context context) throws IOException, InterruptedException {

		Double sum = 0.0;
		int counter = 0;
		Double lastValue = 0.0;

		for (DoubleWritable value : values) {
			sum += value.get();
			counter++;
		}

		lastValue = sum / counter;

		context.write(key, new DoubleWritable(lastValue));
	}
}
