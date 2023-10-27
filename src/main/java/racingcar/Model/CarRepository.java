package racingcar.Model;

import java.util.List;
import racingcar.Model.Car.Car;

public class CarRepository {

    private List<Car> carList;

    public void save(Car car) {
        carList.add(car);
    }

    public Car getCar(int index){


    }
}
