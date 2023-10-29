package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.Util;
import racingcar.view.OutputView;

public class RacingCars {
    private final List<Car> CARS = new ArrayList<>();
    public RacingCars(List<String> carNames) {
        carNames.forEach(car -> CARS.add(new Car(car)));
    }

    public void play() {
        advanceCar();
        OutputView.printRoundResult(CARS);
    }

    public void showWinners() {
        int maxPosition = Util.getMaxPosition(CARS);
        ArrayList<String> winners = CARS.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toCollection(ArrayList::new));
        OutputView.printWinner(winners);
    }

    private void advanceCar() {
        CARS.forEach(Car::validRacingCars);
    }
}
