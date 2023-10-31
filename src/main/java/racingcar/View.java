package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class View {
  static public void printGameStart() {
    System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
  }

  static public List<String> inputCars() {
    String input = Console.readLine();
    List<String> cars = Arrays.asList(input.split(","));
    System.out.println(cars);
    return cars;
  }

  static public void printGameTrialCount() {
    System.out.println("시도할 회수는 몇회인가요?");
    
  }
  
  static  public int inputGameTrialCount(){
    String input = Console.readLine();
    return Integer.parseInt(input);
  }
  
  static public void printProgressState(List<Car> cars, List<Integer> progressState){
    for(int i=0;i<cars.size();i++){
      System.out.println(cars.get(i).getName()+" : "+ "-".repeat(progressState.get(i)));
    }
    System.out.println();
  }
  
  static public void printWinner(List<Car> winnerCars){
    List<String> winnerCarNames= new ArrayList<String>();
    for (Car winnerCar : winnerCars) {
      winnerCarNames.add(winnerCar.getName());
    }
    String result = String.join(", ",winnerCarNames);

    System.out.println("최종 우승자 : "+result);
  }
}
