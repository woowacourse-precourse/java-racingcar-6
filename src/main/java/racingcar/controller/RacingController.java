package racingcar.controller;

import racingcar.view.InputView;

import static java.lang.String.*;
import static racingcar.common.Config.*;
import static racingcar.controller.CarController.createCars;
import static racingcar.view.OutputView.gameStartMessage;
import static racingcar.view.OutputView.eachResultMessage;
import static racingcar.view.OutputView.inputCountMessage;
import static racingcar.view.OutputView.startRacingMessage;
import static racingcar.view.OutputView.printWinner;

public class RacingController {
    private CarController carController = null;
    private final InputView inputView = InputView.createInputView();
    private Integer countNumber = 0;

    private RacingController() {

    }

    public static RacingController createCarController() {
        return new RacingController();
    }

    public void welcome() {
        gameStartMessage();
    }

    public void registerRacer() {
        carController = createCars(inputView.inputCars());
    }

    public void setRacingCount() {
        inputCountMessage();
        countNumber = inputView.inputCountNumber();
    }

    public void startRacing() {
        startRacingMessage();
    }

    public void inRacing() {

        for (int i = 0; i < countNumber; i++) {

            carController.ifForwardCars();

            eachResultMessage(carController.toString());
        }
    }

    public void endRacing() {

        printWinner(format(WINNER_MESSAGE, carController.chooseWinner()));

    }
}
