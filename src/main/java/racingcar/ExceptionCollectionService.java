package racingcar;

import java.util.List;

public class ExceptionCollectionService {
  public ExceptionCollectionService(){}
  // 컨트롤러 만든 곳에서 return 시켜 종료하면
  // 메인까지 return이 안나갈것같은데..
  // 컨트롤러 대신 메인을 사용해야할듯..
  // 아니면 컨트롤러를 기능조합용으로만 하고 ㅇㅇ 메인에서 실행하는 것으로 땅땅
  public boolean isNmaesCheck(List<String> names){
    for(String name : names){
      if (name.length() > 5){
        return false;
      }
    }
    return true;
  }
  public boolean isCoiceCheck(String choice){
    try{
      Integer.parseInt(choice);
      return true;
    }catch (NumberFormatException e){
      return false;
    }
  }
}
