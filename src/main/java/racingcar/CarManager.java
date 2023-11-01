package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarManager {
    private List<Car> cars;

    // 자동차들을 등록합니다.
    public void setCars(List<String> carNames) {

        if (cars == null) {
            cars = new ArrayList<Car>();
        }

        for(String carName : carNames) {
            Car newCar = new Car(carName);
            cars.add(newCar);
        }

        System.out.println(cars.size());
        for(Car car : cars)
        {
            System.out.println(car.getName());
        }
    }

    // TODO : 자동차들을 조회합니다.

    // TODO : 우승자(가장 많이 전진한 자동차)를 구합니다.
}
