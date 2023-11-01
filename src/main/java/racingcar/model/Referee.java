package racingcar.model;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Referee {
    private ArrayList<Car> cars;

    public Referee() {
        this.cars = new ArrayList<>();
    }
    public String getCarProgress() {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(car.getTrace()).append("\n");
        }
        return sb.toString();
    }
    public String getWinners() {
        int maxDistance = cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(Car::getCarName)
                .collect(Collectors.joining(", "));
    }

    public void updateInfo(ArrayList<Car> cars) {
        this.cars = cars;
    }
}
