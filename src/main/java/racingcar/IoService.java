package racingcar;

import java.util.List;

public class IoService {

  public IoService(){}

  public void gameStartMsg(){
    System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
  }
  public void tryChoiceGameMsg(){
    System.out.println("시도할 회수는 몇회인가요?");
  }
  public void resultChoiceGameMsg(){
    System.out.println("실행 결과");
  }
  public String isChampionMsg(String name){
    String msg ="";
    msg += "최종 우승자 : ";
    msg += name;
    // 명단에 공백을 붙여서 출력 해야 하는 느낌
    return msg;
  }
  public String isChampionsMsg(List<String> names){
    String msg = "";
    msg += "최종 우승자 :";
    for(int i = 0; i < names.size();i++){
      msg += " ";
      for(int j = 0; j < 1; i++){
        msg += names.get(i);
        if (names.size()-1 != i){ msg += ",";}
      }
    }
    return msg;
  }



}
