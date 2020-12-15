package se.accelerateit.aopexample.business;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class BusinessAopSpringBootTest {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private BusinessService business1;

  @Test
  public void calculateSomething() {
    logger.info(business1.calculateSomething());
  }

  @Test
  public void calculateSomethingElse() {
    logger.info(business1.calculateSomethingElse());
  }
}
