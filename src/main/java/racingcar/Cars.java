package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    List<Car> cars;
    public Cars(List<String> names){
        cars = new ArrayList<>();
        names.forEach(name -> cars.add(new Car(name)));
    }
}
