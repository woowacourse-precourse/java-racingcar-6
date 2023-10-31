package racingcar;

import java.util.ArrayList;
import java.util.List;

public class GameManager {

  private List<Car> cars = new ArrayList<Car>();

   public void init() {
    System.out.println("초기화");
     View.printGameStart();
     List<String> inputedCars = View.inputCars();
     inputedCars.forEach(car -> cars.add(new Car(car)));
  }
   public void start(){
    System.out.println("시작");


   
  }
}
