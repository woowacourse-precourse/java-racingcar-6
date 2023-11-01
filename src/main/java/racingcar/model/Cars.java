package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars = new ArrayList<>();

    public Cars(String[] carNames) {
        for (int i = 0; i < carNames.length; i++) {
            cars.add(new Car(carNames[i]));
        }
    }

    public void moveAllCars() {
        for (Car car : cars) {
            car.move(RandomNumberGenerator.randomNumber());
        }
    }

    public List<String> compareCarDistances() {
        int maxDistance = cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);

        List<String> winnerCars = cars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(Car::getName)
                .collect(Collectors.toList());

        return winnerCars;
    }

    public List<Car> getCars() {
        return cars;
    }

}
