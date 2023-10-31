package racingcar.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;
import racingcar.model.enums.MovingStatus;
import racingcar.model.enums.SpecialSign;

public class Cars {

    private static final int MIN_PICK_NUMBERS_SIZE = 0;

    private static final String DUPLICATE_CAR_NAME = "중복된 자동차가 존재합니다.";

    private List<Car> cars;

    public Cars(String inputCarNames) {
        List<Car> createdCars = createCars(inputCarNames);
        validateCarDuplicated(createdCars);
        this.cars = createdCars;
    }

    public void updateDistance(List<Integer> createdPickNumbers) {
        IntStream.range(MIN_PICK_NUMBERS_SIZE, createdPickNumbers.size())
                .filter(index -> MovingStatus.canMove(createdPickNumbers.get(index)))
                .forEach(this::forwardCar);
    }

    public int maxDistance() {
        return cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .getAsInt();
    }

    public int carsSize() {
        return cars.size();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    private void forwardCar(int index) {
        findCarByIndex(index).forward();
    }

    private Car findCarByIndex(int index) {
        return cars.get(index);
    }

    private void validateCarDuplicated(List<Car> cars) {
        int originSize = cars.size();
        Set<Car> set = new HashSet<>(cars);

        if (isSameSize(originSize, set.size())) {
            throw new IllegalArgumentException(DUPLICATE_CAR_NAME);
        }
    }

    private boolean isSameSize(int originSize, int setSize) {
        return originSize != setSize;
    }

    private List<Car> createCars(String inputCarNames) {
        return Arrays.stream(inputCarNames.split(SpecialSign.SEPARATOR.getSign()))
                .map(String::trim)
                .map(Car::new)
                .toList();
    }
}
