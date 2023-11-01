package racingcar.control;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.util.Validation;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Control {
    private static int rounds;
    private static final Validation validation = new Validation();
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public void playGame() {
        startGame();
        raceProcess();
        OutputView.printWinner();
    }

    private static void startGame() {
        readyCarName();
        readyRound();
    }

    private static void readyCarName() {
        String input = inputView.requestCarName();
        validation.validateNameInput(input);
        Cars.carNames = Cars.convertStringToList(input);
    }

    private static void readyRound() {
        String roundInput = inputView.requestRoundNumber();
        validation.validateNumberInput(roundInput);
        rounds = Integer.parseInt(roundInput);
    }

    private static void raceProcess() {
        Cars.makeCarList();
        System.out.print("\n실행 결과");
        for (int i = 1; i <= rounds; i++) {
            System.out.println();
            movePosition();
        }
    }
    private static void movePosition() {
        for (Car car : Cars.cars) {
            car.move();
            outputView.printRacingProcess(car.getName(), car.getPosition());
        }
    }
}
