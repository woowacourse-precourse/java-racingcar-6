package racingcar.model;

import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.stream.Collectors;

import static racingcar.utils.Util.getMax;

public class Cars {
    private final ArrayList<Car> CARS = new ArrayList<>();

    public Cars(ArrayList<String> cars) {
        cars.forEach(car -> CARS.add(new Car(car)));
    }

    public void playRacing() {
        move();
        OutputView.printRoundResult(new ArrayList<>(CARS.stream()
                .map(Car::getRoundResult)
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

    private void move() {
        CARS.forEach(Car::move);
    }

    private ArrayList<Integer> getPositions() {
        ArrayList<Integer> positions = new ArrayList<>();
        CARS.forEach(car -> positions.add(car.getPosition()));
        return positions;
    }
}
