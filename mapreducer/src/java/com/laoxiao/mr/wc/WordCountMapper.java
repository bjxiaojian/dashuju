package com.laoxiao.mr.wc;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.util.StringUtils;

import java.io.IOException;

/**
 * 四个参数分别为:maptask的输入数据的key(文本中的一行数据对应的下标)，maptask的输入数据的value(本中的一行数据)
 * maptask的输出数据的key，maptask的输出数据的value
 */
public class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable>{

	//该方法循环调用，从文件的split中读取每行调用一次，把该行所在的下标为key，该行的内容为value
	protected void map(LongWritable key, Text value,
			Context context)
			throws IOException, InterruptedException {
		String[] words = StringUtils.split(value.toString(), ' ');
		for(String w :words){
			context.write(new Text(w), new IntWritable(1));
		}
	}
}
