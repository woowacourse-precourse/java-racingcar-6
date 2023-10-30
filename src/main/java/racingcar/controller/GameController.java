package racingcar.controller;

import static racingcar.view.InputView.*;
import static racingcar.view.OutputView.printRoundResult;
import static racingcar.view.OutputView.printWinners;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Number;

public class GameController {
    private List<Car> cars = new ArrayList<>();
    private Number round;
    private Referee referee;
    private void setUp() {
        List<String> userInput = askCarNames();
        for (String s : userInput) {
            cars.add(Car.createCar(s));
        }
        round = Number.inputUserRounds();
        referee = new Referee(cars);
    }

    public void play() {
        setUp();
        System.out.println("실행 결과");
        for (int i = 0; i < round.getNumber();i++) {
            referee.proceedRound();
            printRoundResult(cars);
        }
        printWinners(referee.determineWinner());
    }
}
