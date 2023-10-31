package racingcar.repository;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class SaveCarList {
    private final List<Car> carList = new ArrayList<>();


    public void addCar(Car car) {
        //domain에서 정의한 CarList에 저장.
        carList.add(car);
    }

    public List<Car> entireCarList(){
        return carList;
    }
}
