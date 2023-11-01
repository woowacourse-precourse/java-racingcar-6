package racingcar.domain;

import static racingcar.constant.GameMessage.COLON;
import static racingcar.constant.GameMessage.DASH;
import static racingcar.constant.GameNumber.STOP_ATTEMPT_NUMBER;

import java.util.ArrayList;
import java.util.List;
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
        List<String> roundResult = new ArrayList<>();

        for (Car car : cars) {
            String moveDash = DASH.repeat(car.getPosition());
            roundResult.add(car.getName() + COLON + moveDash);
        }

        return roundResult;
    }

    public void moveCar() {
        cars.forEach(Car::move);
    }

}
