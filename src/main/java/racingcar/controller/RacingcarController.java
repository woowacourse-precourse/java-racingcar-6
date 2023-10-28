package racingcar.controller;

import racingcar.domain.*;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingcarController {


    private final InputView inputView = InputView.getInstance();
    private final OutputView outputView = OutputView.getInstance();

    private List<Car> carList;
    private int moveCount;

    public void start() {
        input();

        try {
            validate();
        } catch (IllegalArgumentException e) {
            return;
        }
        
        move();
        whoIsWinner();
    }

    private void input() {
        carList = inputView.inputCarList();
        moveCount = inputView.inputMoveCount();
    }

    private void validate() throws IllegalArgumentException {
        try {
            InputValidator.validate(carList);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }


    private void move() {
        outputView.printStart();

        for (int i = 0; i < moveCount; i++) {
            for (Car car : carList) {
                int random = RandomGenerator.generate();
                if (Judge.judge4OrMore(random))
                    car.move();
            }

            outputView.printCarListStatus(carList);
        }
    }

    private void whoIsWinner() {
        List<Car> winnerCarList = Comparator.compare(carList);
        outputView.printWinner(winnerCarList);
    }

}
