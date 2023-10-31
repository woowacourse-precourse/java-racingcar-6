package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Cars {
    private static final int INDEX_ZERO = 0;

    private final List<Car> cars;

    public Cars(String[] carNames) {
        validateCarNames(carNames);
        this.cars = initCars(carNames);
    }

    private void validateCarNames(String[] carNames) {
        long distinctCount = Arrays.stream(carNames)
                .distinct()
                .count();
        if (carNames.length > distinctCount) {
            throw new IllegalArgumentException("[ERROR] 중복된 이름을 가질 수 없습니다.");
        }
    }

    public List<Car> initCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();

        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    public void progressAllCars() {
        for (Car car : cars) {
            car.progress();
        }
    }

    public List<Car> getWinners() {
        List<Car> winners = new ArrayList<>();
        Collections.sort(cars);
        int maxPosition = cars.get(INDEX_ZERO).getPosition();
        for (Car car : cars) {
            if (maxPosition == car.getPosition()) {
                winners.add(car);
            }
        }
        return winners;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

}
