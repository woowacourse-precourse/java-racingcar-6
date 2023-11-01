package racingcar.domain;

import static racingcar.constant.GameMessage.COLON;
import static racingcar.constant.GameMessage.DASH;
import static racingcar.constant.GameNumber.STOP_ATTEMPT_NUMBER;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.view.OutputView;

public class Game {
    private final List<Car> cars;
    private int attemptNumber;
    private Umpire umpire;

    public Game(List<Car> cars, int attemptNumber) {
        this.cars = cars;
        this.attemptNumber = attemptNumber;
        umpire = new Umpire(cars);
    }

    public void startRacing() {
        playRacing();
        umpire.showWinner();
    }

    public void playRacing() {
        while (attemptNumber != STOP_ATTEMPT_NUMBER) {
            moveCar();
            OutputView.printRoundResult(getRoundResult());
            attemptNumber--;
        }
    }

    public List<String> getRoundResult() {
        return cars.stream()
                .map(car -> car.getName() + COLON + DASH.repeat(car.getPosition()))
                .collect(Collectors.toList());
    }

    public void moveCar() {
        cars.forEach(Car::move);
    }

}
