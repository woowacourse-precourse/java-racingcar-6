package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class GameConfig {

    public List<Car> createCars(String carNames) {
        List<Car> cars = new ArrayList<>();

        String[] split = carNames.split(",");
        for (String carName : split) {
            if (1 > carName.length() || carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 1글자 이상, 5글자 미만까지 가능합니다.");
            } else {
                Car car = new Car(carName);
                cars.add(car);
            }
        }
        return cars;
    }

    public void moveCount(int number) {

    }
}
