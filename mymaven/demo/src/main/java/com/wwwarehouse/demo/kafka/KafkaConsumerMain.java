package com.wwwarehouse.demo.kafka;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;

public class KafkaConsumerMain {

	public static void main(String[] args) {
		Properties props = new Properties();
	    props.put("bootstrap.servers", "localhost:9092,localhost:9093,localhost:9094");
	    props.put("group.id", "group-1");
	    props.put("enable.auto.commit", "false");
	    props.put("auto.commit.interval.ms", "1000");
	    props.put("session.timeout.ms", "30000");
	    props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
	    props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
	    
	    KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
	    consumer.subscribe(Arrays.asList("my-replicated-topic", "my-topic"));
	    
//	    final int minBatchSize = 200;
//	    List<ConsumerRecord<String, String>> buffer = new ArrayList<ConsumerRecord<String, String>>();
	    
//	    while (true) {
//	        ConsumerRecords<String, String> records = consumer.poll(100);
//	        for (ConsumerRecord<String, String> record : records) {
//	        	System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
//	            buffer.add(record);
//	        }
//			if (buffer.size() >= minBatchSize) {
//				// insertIntoDb(buffer);
//				consumer.commitSync();
//				buffer.clear();
//				
//				try {
//					Thread.sleep(10000);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//	        
//	    }
	    
	    // 订阅指定topic的指定分区 begin
		String topic = "foo";
		TopicPartition partition0 = new TopicPartition(topic, 0);
		TopicPartition partition1 = new TopicPartition(topic, 1);
		consumer.assign(Arrays.asList(partition0, partition1));
		// 订阅指定topic的指定分区 end
	    
	    // 处理完整个分区后再提交偏移量
	    try {
	         while(true) {
	             ConsumerRecords<String, String> records = consumer.poll(Long.MAX_VALUE);
	             // 获取分区集合
	             for (TopicPartition partition : records.partitions()) {
	                 List<ConsumerRecord<String, String>> partitionRecords = records.records(partition);
	                 for (ConsumerRecord<String, String> record : partitionRecords) {
	                     System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
	                 }
	                 // 获取该分区中最后一条消息的偏移量
	                 long lastOffset = partitionRecords.get(partitionRecords.size() - 1).offset();
	                 // 提交这个偏移量+1，表示下次从这个偏移量开始处理
	                 // 已提交的offset应始终是你的程序将读取的下一条消息的offset。因此，调用commitSync（offsets）时，你应该加1个到最后处理的消息的offset。
	                 consumer.commitSync(Collections.singletonMap(partition, new OffsetAndMetadata(lastOffset + 1)));
	             }
	         }
		} finally {
			System.out.println(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss")+" ,进入finally");
			consumer.close();
		}
	}
	
}
