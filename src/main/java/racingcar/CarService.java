package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarService {

  List<Car> getCars(List<String> splitInput) {
    List<Car> cars = new ArrayList<>();

    for (int i = 0; i < splitInput.size(); i++) {
      Car car = new Car(splitInput.get(i));
      cars.add(car);
    }

    return cars;
  }
}
