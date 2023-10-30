package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
      inputCarName();


    }
    public static String inputCarName(){
      System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
      String input = Console.readLine();
      return input;
    }

    public String inputCarNameValidation(String inputCarName){
      return null;
    }

    public Map<String,Integer> cars(String inputCarName){
      return null;
    }

    public String inputAttempts(){
      return null;
    }

    public String inputAttemptsValidation(String inputAttempts){
      return null;
    }

    public int randomNumber(){
      return 0;
    }

    public Map<String,Integer> movementCount(Map<String,Integer> cars){
      return null;
    }

    public void progressDisplay(Map<String,Integer> cars){

    }

    public void winnerDisplay(Map<String,Integer> cars){

    }
}
