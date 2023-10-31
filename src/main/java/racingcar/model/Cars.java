package racingcar.model;

import static racingcar.util.Util.getMax;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.view.OutputView;

public class Cars {
    private final List<Car> CARS = new ArrayList<>();

    public Cars(List<String> cars) {
        cars.forEach(car -> CARS.add(new Car(car)));
    }

    public void racePerTryCount() {
        move();
        OutputView.printTryResult(new ArrayList<>(CARS.stream()
                .map(Car::getTryResult)
                .collect(Collectors.toList())
        ));
    }

    public void showWinners() {
        OutputView.printWinner(new ArrayList<>(CARS.stream()
                .filter(car -> car.isWinner(getMax(getPositions())))
                .map(Car::getName)
                .collect(Collectors.toList())
        ));
    }

    public void move() {
        CARS.forEach(Car::move);
    }

    private List<Integer> getPositions() {
        List<Integer> positions = new ArrayList<>();
        CARS.forEach(car -> positions.add(car.getPosition()));
        return positions;
    }
}