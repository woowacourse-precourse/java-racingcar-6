package racingcar;

import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class MoveResult {
  public void move(List<String> carNames){
    System.out.println("실행 결과");
    for (String name : carNames) {
      System.out.println(name+" : "+raceResult());
  }

  }
  
  private String raceResult(){
    String road = "";
    
    if(Randoms.pickNumberInRange(0,9)>=4) {
      road = "-";
    }
    
    return road;
    
  }

}
