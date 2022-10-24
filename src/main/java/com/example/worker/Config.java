package com.example.worker;


import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * The type Config.
 */
@Configuration
public class Config {

  @Value("${queue.name}")
  private String queueName;

  /**
   * Queue queue.
   *
   * @return the queue
   */
  @Bean
  public Queue queue() {
    return new Queue(queueName);
  }

  /**
   * Producer producer.
   *
   * @return the producer
   */
  @Bean
  public Producer producer() {
    return new Producer();
  }

  /**
   * Consumer 1 consumer.
   *
   * @return the consumer
   */
  @Bean
  public Consumer consumer1() {
    return new Consumer(1);
  }

  /**
   * Consumer 2 consumer.
   *
   * @return the consumer
   */
  @Bean
  public Consumer consumer2() {
    return new Consumer(2);
  }

}
