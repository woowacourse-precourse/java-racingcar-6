package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class IoService {

  public IoService(){}


  public String gameStartInputMsg(){
    System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    String input = Console.readLine();
    return input;
  }public List<String> nameChangeNames(String isName){
    List<String> isNmaes = Arrays.asList(isName.split(","));
    return isNmaes;
    //디버깅 완료
  }public boolean nameExceptionCheck(){


    return false;
  }
  public String tryChoiceGameMsg(){
    System.out.println("시도할 회수는 몇회인가요?");
    String input = Console.readLine();
    return input;
  }
  public Object tryGams(){

    return null;
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
