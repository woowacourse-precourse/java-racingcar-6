package racingcar.model;

import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class RacingCars {
    private final ArrayList<Car> CARS = new ArrayList<>();

    public RacingCars(ArrayList<String> cars) {
        cars.forEach(car -> CARS.add(new Car(car)));
    }

    public void playRound() {
        go();
        OutputView.printRoundResult(new ArrayList<>(CARS.stream()
                                                        .map(Car::getRoundResult)
                                                        .collect(Collectors.toList())));
    }

    private void go() {
        CARS.forEach(Car::moveForward);
    }
    private ArrayList<Integer> getPosition() {
        ArrayList<Integer> positions = new ArrayList<>();
        CARS.forEach(car -> positions.add(car.getPosition()));
        return positions;
    }
}
