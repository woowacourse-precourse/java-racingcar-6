package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.dto.RaceResult;

public class Race {
    private static final String NO_ONE_EXIST = "참가자가 존재하지 않습니다.";

    private final List<Car> cars = new ArrayList<>();

    public Race(String carNames) {
        List<Car> cars = toCars(carNames);
        this.cars.addAll(cars);
    }

    private List<Car> toCars(String carNames) {
        String[] names = carNames.split(",");
        validate(names);

        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }

        return cars;
    }

    private void validate(String[] names) {
        if (names.length == 0) {
            throw new IllegalArgumentException(NO_ONE_EXIST);
        }
    }

    public void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    public RaceResult findWinners() {
        return null;
    }

    public List<Car> getCars() {
        return cars;
    }
}
