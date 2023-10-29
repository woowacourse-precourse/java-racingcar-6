package racingcar.domain;

import java.util.Arrays;
import java.util.List;

public class RacingGameDemo {
    private final List<CarDemo> cars;

    public RacingGameDemo(String carNames) {
        List<String> members = Arrays.asList(carNames.split(","));
        this.cars = members.stream()
                .map(member -> new CarDemo(member))
                .toList();
    }

    public RacingGameDemo(List<CarDemo> cars) {
        this.cars = cars;
    }

    public List<CarDemo> getCars() {
        return cars;
    }

    public List<CarDemo> findWinner() {
        int maxPosition = cars.stream()
                .mapToInt(CarDemo::getPosition)
                .max()
                .getAsInt();

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();
    }
}
