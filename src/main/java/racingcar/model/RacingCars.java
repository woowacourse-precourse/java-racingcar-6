package racingcar.model;

import java.util.ArrayList;
import java.util.stream.Collectors;
import racingcar.Util;
import racingcar.view.OutputView;

public class RacingCars {
    private final ArrayList<Car> CARS = new ArrayList<>();
    public RacingCars(ArrayList<String> carNames) {
        carNames.forEach(car -> CARS.add(new Car(car)));
    }

    public void play(){
        go();
        OutputView.printRoundResult(CARS);
    }

    public void showWinners(){
        int maxPosition = Util.getMaxPosition(CARS);
        ArrayList<String> winners = CARS.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toCollection(ArrayList::new));
        OutputView.printWinner(winners);
    }

    private void go(){
        CARS.forEach(Car::validRacingCars);
    }
}
