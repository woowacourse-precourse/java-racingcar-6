package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Cars {
    private List<Car> cars = new ArrayList<>();

    public Cars(String[] carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public void attempt() {
        for (Car car : cars) {
            car.attempt();
        }
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner("\n");
        for (Car car : cars) {
            stringJoiner.add(car.toString());
        }
        return stringJoiner.toString();
    }
}
