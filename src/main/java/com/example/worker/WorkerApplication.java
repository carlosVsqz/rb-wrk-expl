package com.example.worker;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

/**
 * The type Worker application.
 */
@SpringBootApplication
public class WorkerApplication implements CommandLineRunner {

  @Resource
  private Producer producer;

  /**
   * The entry point of application.
   *
   * @param args the input arguments
   */
  public static void main(String[] args) {
    SpringApplication.run(WorkerApplication.class, args);
  }

  @Override
  public void run(String... args) {
    for (int i = 10000; i < 10010; i++) {
      producer.sendMsg(i);
    }
  }
}