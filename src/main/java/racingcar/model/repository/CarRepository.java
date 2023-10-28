package racingcar.model.repository;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.domain.Car;

public class CarRepository {
    List<Car> cars;

    public CarRepository(){
        cars = new ArrayList<>();
    }

    public void save(String name){
        cars.add(new Car(name));
    }
}
