package racingcar.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.model.Car;
import racingcar.view.InputView;

public class Controller {
    private final InputView inputView = new InputView();
    //    private final OutputView outputView = new OutputView();
    private final List<Object> carsList = new ArrayList<>();
    private String trial;

    public void run() {
        startGame();
        playGame();
        endGame();
    }

    public void startGame() {
        String[] carsList = inputView.inputCarsName();
        trial = inputView.inputTrial();

    }

    public void playGame() {
        moveCar();
        showRoundResult();
    }

    public void endGame() {
        findWinner();
        showWinner();
    }


}
