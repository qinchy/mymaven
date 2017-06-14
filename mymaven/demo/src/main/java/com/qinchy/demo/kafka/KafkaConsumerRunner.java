package com.qinchy.demo.kafka;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.errors.WakeupException;

public class KafkaConsumerRunner implements Runnable {
	private final AtomicBoolean closed = new AtomicBoolean(false);
	private final KafkaConsumer consumer;

	public KafkaConsumerRunner(KafkaConsumer consumer) {
		this.consumer = consumer;
	}

	public void run() {
		try {
			consumer.subscribe(Arrays.asList("topic"));
			while (!closed.get()) {
				ConsumerRecords records = consumer.poll(10000);
				// Handle new records
			}
		} catch (WakeupException e) {
			// Ignore exception if closing
			if (!closed.get()) {
				throw e;
			}
		} finally {
			consumer.close();
		}
	}

	// Shutdown hook which can be called from a separate thread
	public void shutdown() {
		closed.set(true);
		consumer.wakeup();
	}
}