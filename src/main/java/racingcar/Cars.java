package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars() {
        this.cars = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public List<Car> getCars() {
        return cars;
    }

    public boolean contains(String carName) {
        return cars.stream()
                .anyMatch(car -> car.getName().equals(carName));
    }

    private List<String> findWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();
    }

    public void printFinalResult() {
        List<String> winners = findWinners();
        String result = String.join(", ", winners);
        System.out.println("최종 우승자 : " + result);
    }
}
