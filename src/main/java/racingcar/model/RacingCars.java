package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.Util;
import racingcar.view.OutputView;

public class RacingCars {

    private final List<Car> cars = new ArrayList<>();

    public RacingCars(List<String> carNames) {
        carNames.forEach(name -> cars.add(new Car(name)));
    }

    public void play() {
        advanceCar();
        OutputView.printRoundResult(getCarStatus());
    }

    public void showWinners() {
        List<String> winners = getWinners();
        OutputView.printWinner(winners);
    }


    private List<String> getWinners() {
        int maxPosition = Util.getMaxPosition(cars);
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private List<Car> getCarStatus() {
        return new ArrayList<>(cars);
    }

    private void advanceCar() {
        cars.forEach(Car::validRacingCars);
    }
}
