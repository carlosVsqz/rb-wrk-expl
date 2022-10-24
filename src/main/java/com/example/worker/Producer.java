package com.example.worker;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import javax.annotation.Resource;

/**
 * The type Producer.
 */
public class Producer {

  @Resource
  private Queue queue;

  @Resource
  private RabbitTemplate rabbitTemplate;

  /**
   * Send msg.
   *
   * @param number the number
   */
  public void sendMsg(final Integer number) {
    rabbitTemplate.convertAndSend(queue.getName(), number);
    System.out.println("Sent: " + number);
  }

}