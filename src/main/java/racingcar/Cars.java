package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars = new ArrayList<>();

    public Cars(List<String> names) {
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    public List<CarStatusDto> moveAllCars() {
        return this.cars.stream()
                .map(car -> car.move(RandomNumberMaker.makeRandomNumber()))
                .collect(Collectors.toList());
    }

    public List<String> getWinners() {
        int maxPosition = 0;
        List<String> winners = new Stack<>();
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                winners.clear();
                winners.add(car.getName());
                maxPosition = car.getPosition();
            } else if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }

        return winners;
    }

}


