package domain.fisrtCollection;

import domain.strategy.MoveStrategy;
import domain.valueObject.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cars {
    private static final String ERROR_MESSAGE_CAR_NAME_DUPLICATE = "이름은 중복될 수 없습니다.";
    private static final String ERROR_MESSAGE_EMPTY_CAR_LIST = "자동차 목록을 확인해주세요";
    private static final int ZERO = 0;

    private final List<Car> cars;


    public Cars(final List<Car> cars) {
        checkNullAndEmpty(cars);
        List<Car> notModifiedCar = List.copyOf(cars);
        checkDuplicate(notModifiedCar);

        this.cars = notModifiedCar;
    }

    private static void checkDuplicate(final List<Car> cars) {
        if (duplicateCar(cars)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_CAR_NAME_DUPLICATE);
        }
    }

    private static boolean duplicateCar(final List<Car> cars) {
        return cars.stream().map(Car::getName).collect(Collectors.toSet()).size() != cars.size();
    }

    private void checkNullAndEmpty(List<Car> cars) {
        if (Objects.isNull(cars) || cars.isEmpty()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_EMPTY_CAR_LIST);
        }
    }

    public void move(MoveStrategy moveStrategy) {
        for (int i = ZERO; i < cars.size(); i++) {
            cars.get(i).forward(moveStrategy);
        }
    }

    public List<String> getWinnerName() {
        List<Car> cars = getStoredPosition();
        Car winner = cars.get(ZERO);

        return cars.stream().filter(winner::isEqualPosition).map(Car::getName).collect(Collectors.toUnmodifiableList());
    }

    private List<Car> getStoredPosition() {
        List<Car> cars = new ArrayList<>(this.cars);
        cars.sort(Car::isWinning);

        return cars;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
