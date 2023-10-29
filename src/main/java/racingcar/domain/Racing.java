package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Racing {

    private static final int START_RANDOM_NUMBER = 0;
    private static final int END_RANDOM_NUMBER = 9;
    private static final int MOVE_FORWARD_THRESHOLD = 4;

    private final List<Car> cars;

    public Racing() {
        cars = new ArrayList<>();
    }

    public List<Car> getCars() {
        return cars;
    }

    public void generateCars(List<String> carsName) {
        carsName.stream()
                .map(Car::of)
                .forEach(cars::add);
    }

    public void runRace() {
        cars.stream()
                .filter(car -> isMoveForward())
                .forEach(Car::moveForward);
    }

    private boolean isMoveForward() {
        return Randoms.pickNumberInRange(START_RANDOM_NUMBER, END_RANDOM_NUMBER)
                >= MOVE_FORWARD_THRESHOLD;
    }

    public List<Car> getWiningCars() {
        int maxForwardStep = getMaxForwardStep();
        return cars.stream()
                .filter(car -> car.getForwardStep() == maxForwardStep)
                .toList();
    }

    private int getMaxForwardStep() {
        return cars.stream()
                .max(Comparator.comparing(Car::getForwardStep))
                .map(Car::getForwardStep)
                .orElse(0);
    }
}
