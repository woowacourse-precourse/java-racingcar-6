package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.util.Validator;

public class Cars {
    public List<Car> cars;

    public Cars(List<String> carNames) {
        List<Car> carList = new ArrayList<>();
        for (String carName : carNames) {
            Car car = new Car(carName);
            carList.add(car);
        }
        this.cars = carList;
    }

    public List<String> getFinalWinner() {
        int maxPosition = findMaxPosition();
        List<String> names = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                names.add(car.getName());
            }
        }
        return names;
    }

    private int findMaxPosition() {
        int maxPosition = Integer.MIN_VALUE;
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }
}
