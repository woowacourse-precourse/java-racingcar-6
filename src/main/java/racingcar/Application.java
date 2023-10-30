package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashMap;
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

    public static String[] inputCarNameSplit(String inputCarName){
      String[] cars = inputCarName.split(",");

      if(cars.length<2){
        throw new IllegalArgumentException("이름은 쉼표(,) 기준으로 구분합니다.");
      }

      return cars;
    }

    public static Map<String,Integer> inputCarNameValidation(String[] inputCarNameSplit){
      Map<String,Integer> cars = new HashMap<>();

      for (String car : inputCarNameSplit){
        if(car.length()>5){
          throw new IllegalArgumentException("자동차이름은 5자 이하만 가능합니다.");
        }

        cars.put(car,0);
      }

      return cars;
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
