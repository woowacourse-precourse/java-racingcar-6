package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private final List<Car> cars = new ArrayList<>();

    public void addCars(String carNames) {
        Arrays.stream(carNames.split(","))
                .forEach(name -> cars.add(new Car(name)));
    }

    public void moveCars(int lowerBound, int upperBound) {
        cars.forEach(car -> {
            int moveCondition = Randoms.pickNumberInRange(lowerBound, upperBound);
            car.moveCar(moveCondition);
        });
    }

    public String getCarsStatus() {
        StringBuilder statusBuilder = new StringBuilder();
        cars.forEach(car -> {
            statusBuilder.append(car.getCarStatus())
                    .append("\n");
        });
        return statusBuilder.toString();
    }

    public Car findWinnerCar() {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("car list is empty"));
    }

    public String findRaceWinners() {
        Car winnerCar = findWinnerCar();
        return cars.stream()
                .filter(car -> car.isSameDistanceAs(winnerCar))
                .map(Car::getCarName)
                .collect(Collectors.joining(", "));
    }
}
