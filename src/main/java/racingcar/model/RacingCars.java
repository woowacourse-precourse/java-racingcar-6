package racingcar.model;

import static racingcar.Util.getMax;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.view.OutputView;

public class RacingCars {
    private final List<Car> cars = new ArrayList<>();

    public RacingCars(List<String> carNames) {
        carNames.forEach(name -> cars.add(new Car(name)));
    }

    public void playRound() {
        moveCars();
        OutputView.printRoundResult(new ArrayList<>(cars.stream()
                .map(Car::getRoundResult)
                .collect(Collectors.toList())
        ));
    }

    public void showWinners() {
        OutputView.printWinner(new ArrayList<>(cars.stream()
                .filter(car -> car.isWinner(getMax((ArrayList<Integer>) getPositions())))
                .map(Car::getName)
                .collect(Collectors.toList())
        ));
    }

    private void moveCars() {
        cars.forEach(Car::go);
    }

    private List<Integer> getPositions() {
        return cars.stream()
                .map(Car::getPosition)
                .collect(Collectors.toList());
    }

}