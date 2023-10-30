package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

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


    public void goForward(int attemptCount) {
        for (int i = 0; i < attemptCount; i++) {
            cars.forEach(car -> {
                car.goForward();
                System.out.println(car.getStatusMessage());
            });
            System.out.println();
        }
    }

    public String getWinningCarNames() {
        Car winnerCar = cars.stream().max(Car::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("우승 차가 존재하지 않습니다"));

        return cars.stream()
                .filter(car -> car.isEqualPosition(winnerCar))
                .map(Car::getCarName)
                .collect(Collectors.joining(", "));
    }
}
