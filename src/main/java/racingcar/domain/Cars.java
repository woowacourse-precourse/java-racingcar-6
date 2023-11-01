package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    public List<Car> cars;

    public Cars() {
    }

    public void add(Car car) {
        cars.add(car);
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
