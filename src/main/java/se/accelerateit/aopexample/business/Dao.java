package se.accelerateit.aopexample.business;

import org.springframework.stereotype.Repository;
import se.accelerateit.aopexample.aspect.SuperSpecial;

@Repository
public class Dao {

  @SuperSpecial
  public String retrieveSomething(){
    return "RETURN VALUE FROM Dao1";
  }

  public String retrieveSomethingElse(){
    return "ANOTHER RETURN VALUE FROM Dao1!!";
  }

}
