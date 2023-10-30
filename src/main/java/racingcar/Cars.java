package racingcar;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Cars {

    private List<Car> cars;

    private Cars(List<Car> cars) {
        validate(cars.size());
        this.cars = cars;
    }

    private void validate(int size) {
        if (size == 0) {
            throw new IllegalArgumentException("자동차가 존재하지 않습니다");
        }
    }

    public static Cars of(List<String> carNames) {

        List<Car> carList = carNames.stream()
                .map(name -> new Car(new CarName(name)))
                .toList();

        return new Cars(carList);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public void goForward(int attemptCount) {
        for (int i = 0; i < attemptCount; i++) {
            cars.forEach(car -> {
                car.goForward();
                System.out.println(car.getStatusMessage());
            });
            System.out.println();
        }
    }
}
