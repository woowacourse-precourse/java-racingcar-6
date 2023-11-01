package racingcar.domain;

import java.util.List;

public class ExceptionCheck {
  public ExceptionCheck(){}
  public boolean isCarLengthOverCheck(List<String> carList){
    for (String car : carList){
      if (car.length() > 5){
        return true;
      }
    }
    return false;
  }
}
