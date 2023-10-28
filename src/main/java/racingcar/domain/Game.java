package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.view.OutputView;

public class Game {
    private final Movement move;
    private final List<Car> cars;
    private int attemptNumber;

    public Game(List<Car> cars, int attemptNumber) {
        this.cars = cars;
        this.attemptNumber = attemptNumber;
        move = new Movement();
    }

    public void playRacing() {
        OutputView.printResultMessage();
        while (attemptNumber != 0) {
            move.moveCar(cars);
            OutputView.printRoundResult(getRoundResult());
            attemptNumber--;
        }
    }

    public List<String> getRoundResult() {
        List<String> roundResult = new ArrayList<>();

        for (Car car : cars) {
            String moveDash = "-".repeat(car.getPosition());
            roundResult.add(car.getName() + " : " + moveDash);
        }

        return roundResult;
    }

}
