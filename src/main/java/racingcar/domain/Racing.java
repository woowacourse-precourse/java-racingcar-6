package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        validateUniqueName(carsName);
        carsName.stream()
                .map(Car::of)
                .forEach(cars::add);
    }

    private void validateUniqueName(List<String> carsName) {
        Set<String> set = new HashSet<>();
        carsName.forEach(carName -> {
            if (!set.add(carName)) {
                throw new IllegalArgumentException("중복된 자동차 이름입니다.");
            }
        });
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
