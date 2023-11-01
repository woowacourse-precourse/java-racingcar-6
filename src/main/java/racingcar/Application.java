package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
      String inputCarName = inputCarName();
      String[] carNameSplit = inputCarNameSplit(inputCarName);
      inputCarNameValidation(carNameSplit);
      Map<String, Integer> cars = createCars(carNameSplit);

      String inputAttempts = inputAttempts();
      int attempts = inputAttemptsValidation(inputAttempts);

      for(int count = 1 ; count <= attempts ; count++){
        cars = movementCount(cars);
        progressDisplay(cars);
      }
      winnerDisplay(cars);
    }

    public static String inputCarName(){
      System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
      String input = Console.readLine();
      return input;
    }

    public static String[] inputCarNameSplit(String inputCarName){
      String[] cars = inputCarName.split(",");

      if(cars.length<2){
        throw new IllegalArgumentException("자동차는 최소 2대 이상 이어야 합니다. 이름은 쉼표(,) 기준으로 구분합니다.");
      }

      return cars;
    }

    public static void inputCarNameValidation(String[] inputCarNameSplit){
      for (String car : inputCarNameSplit){
        if(car.length()>5){
          throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
      }
    }

  public static Map<String,Integer> createCars(String[] inputCarNameSplit){
    Map<String,Integer> cars = new HashMap<>();
    for (String car : inputCarNameSplit){
      cars.put(car,0);
    }
    return cars;
  }

    public static String inputAttempts(){
      System.out.println("시도할 회수는 몇회인가요?");
      String input = Console.readLine();
      return input;
    }

    public static int inputAttemptsValidation(String inputAttempts){
      try {
        int attempts = Integer.parseInt(inputAttempts);
        return attempts;

      } catch (NumberFormatException e){
        throw new IllegalArgumentException("숫자만 입력해 주세요.");
      }
    }

    public static Map<String,Integer> movementCount(Map<String,Integer> cars){

      cars.forEach((carName, movement) -> {
        int number = Randoms.pickNumberInRange(1, 9);

        if(number>=4){
          movement = movement.intValue();
          movement++;
          cars.replace(carName,movement);
        }
      });
      return cars;
    }

    public static void progressDisplay(Map<String,Integer> cars){
      cars.forEach((carName, movement) -> {
        String result = "";
        for(int i =  1; i<=movement ; i++){
          result+="-";
        }
        System.out.println(carName + " : " + result);
      });
      System.out.println("");
    }

    public static void winnerDisplay(Map<String,Integer> cars){
      StringJoiner winner = new StringJoiner(",");
      Integer maxValue = Collections.max(cars.values());
      Set<Map.Entry<String, Integer>> entrySet = cars.entrySet();
      for(Map.Entry<String,Integer> entry: entrySet){
        if(entry.getValue() == maxValue){
          winner.add(entry.getKey());
        }
      }
      System.out.println("최종 우승자 : " + winner);
    }

}
