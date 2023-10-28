package racingcar;

import java.util.List;

public class ExceptionCollectionService {
  public ExceptionCollectionService(){}

  // isNameCheck 는 컨트롤에서 만들고 여긴 기능들만
  public boolean isLengthOverCheck(List<String> names){
    for(String name : names){
      if (name.length() > 5){
        return false;
      }
    }
    return true;
  }
  //isCoiceCheck 는 컨트롤에서 사용하고 이 메서드는 따로 이름
  // Exception 레벨별로 구분

  // isNumberParsingCheck -> int 범위초과, 문자열을 분리하려 했으나 기술 부족
  public boolean isNumberParsingCheck(String choice){
    try
    { Integer.parseInt(choice); return true;
    }catch (NumberFormatException e){ return false;}
  }
  public boolean isPositiveIntegerCheck(int number){
    return number > 0;
  }




}
