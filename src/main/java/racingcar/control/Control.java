package racingcar.control;


import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.util.Validation;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Control {
    private static int rounds;

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
        String input = InputView.requestCarName();
        Validation.validateNameInput(input);
        Cars.carNames = Cars.convertStringToList(input);
    }

    private static void readyRound() {
        String roundInput = InputView.requestRoundNumber();
        Validation.validateNumberInput(roundInput);
        rounds = Integer.parseInt(roundInput);
    }

    private static void raceProcess() {
        Cars.putObject();
        System.out.print("\n실행 결과");
        for (int i = 1; i <= rounds; i++) {
            System.out.println();
            movePosition();
        }
    }
    private static void movePosition() {
        for (Car car : Cars.cars) {
            car.move();
            OutputView.printRacingProcess(car.getName(), car.getPosition());
        }
    }
}
