package com.example.worker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.util.StopWatch;

import java.math.BigInteger;

/**
 * The type Consumer.
 */
@RabbitListener(queues = "${queue.name}")
public class Consumer {

  private static final Logger LOG = LoggerFactory.getLogger(Consumer.class);

  private final int srNo;

  /**
   * Instantiates a new Consumer.
   *
   * @param srNo the sr no
   */
  public Consumer(int srNo) {
    this.srNo = srNo;
  }

  /**
   * Receive msg.
   *
   * @param number the number
   */
  @RabbitHandler
  public void receiveMsg(final Integer number) {
    StopWatch stopWatch = new StopWatch();
    stopWatch.start();

    LOG.info("Received ({}): [{}]", srNo, number);
    BigInteger nextPrime = nextPrime(number);

    LOG.info("Num: [{}]", nextPrime);
    stopWatch.stop();

    LOG.info("Consumer [{}]. Done in: [{}]s", srNo, stopWatch.getTotalTimeSeconds());
  }

  private BigInteger nextPrime(int number) {
    BigInteger veryBig = new BigInteger(String.valueOf(number));
    return veryBig.nextProbablePrime();
  }

}