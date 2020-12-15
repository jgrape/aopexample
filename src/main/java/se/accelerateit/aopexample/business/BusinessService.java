package se.accelerateit.aopexample.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import se.accelerateit.aopexample.aspect.SuperSpecial;


@Service
public class BusinessService {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  private final Dao dao;

  public BusinessService(Dao dao) {
    this.dao = dao;
  }

  @SuperSpecial
  public String calculateSomething(){
    String value = dao.retrieveSomething();
    logger.info("In Business - {}", value);
    return value;
  }

  public String calculateSomethingElse(){
    String value = dao.retrieveSomethingElse();
    logger.info("In Business - {}", value);
    return value;
  }
}