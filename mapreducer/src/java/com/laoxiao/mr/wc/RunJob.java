package com.laoxiao.mr.wc;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class RunJob {

	public static void main(String[] args) {
		//config将src下的class文件都打包
		Configuration config =new Configuration();
		//在本地执行mapreduce时加上下面两句，设置namenode和resourcemanager的主机名，从hdfs上下载输入文件wc.txt
//		config.set("fs.defaultFS", "hdfs://node1:8020");
//		config.set("yarn.resourcemanager.hostname", "node1");
		//在本地直接调用，执行过程在服务器上，加上下面这句
		config.set("mapred.jar", "C:\\Users\\Administrator\\Desktop\\wc.jar");
		try {
			FileSystem fs =FileSystem.get(config);
			
			Job job =Job.getInstance(config);
			job.setJarByClass(RunJob.class);
			
			job.setJobName("wc");
			
			job.setMapperClass(WordCountMapper.class);
			job.setReducerClass(WordCountReducer.class);
			
			job.setMapOutputKeyClass(Text.class);
			job.setMapOutputValueClass(IntWritable.class);

			//输入文件的路径
			FileInputFormat.addInputPath(job, new Path("/usr/input/"));

			//输出文件的路径，该路径不能手动创建
			Path outpath =new Path("/usr/output/wc");
			//如果该目录存在，应先删除，有程序创建
			if(fs.exists(outpath)){
				fs.delete(outpath, true);
			}
			FileOutputFormat.setOutputPath(job, outpath);
			
			boolean f= job.waitForCompletion(true);
			if(f){
				System.out.println("job 任务完成");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
