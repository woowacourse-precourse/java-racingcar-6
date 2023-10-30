package racingcar;

import racingcar.util.RandomNumberGenerator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Race {
    private List<Car> cars;
    private List<Car> winners = new ArrayList<>();


    public Race(List<Car> cars) {
        this.cars = cars;
    }

    public boolean canCarGoForward() {
        int randomNumber = RandomNumberGenerator.getNumber();

        if (randomNumber >= 4) {
            return true;
        }
        return false;
    }

    public void tryMoveCar(Car car) {
        if (canCarGoForward()) {
            car.goForward();
        }
    }

    public void runOneRound() {
        for (Car car : cars) {
            tryMoveCar(car);
        }
    }

    public void setWinners(List<Car> cars) {
        winners = (List<Car>) cars.stream()
                .max(Comparator.comparing(Car::getDistance))
                .orElseThrow();
    }

    public List<Car> getWinners() {
        return winners;
    }


}
