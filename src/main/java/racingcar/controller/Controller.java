package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Racing;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    Racing racing = new Racing();
    private List<Car> racingCars = new ArrayList<>();
    private int gameCount;
    private int winnerPosition;

    public void playgame() {
        inPutInformation();
        play();
        selectWinner();
    }

    public void inPutInformation() {
        racingCars = inputView.askName();
        gameCount = inputView.askGameCount();
    }

    public void play() {
        for (int i = 0; i < gameCount; i++) {
            racing.racingRound(racingCars);
            outputView.showCarPosition(racingCars);
        }
    }

    public void selectWinner() {
        winnerPosition = racing.winnerPosition(racingCars);
        outputView.showWinner(racingCars, winnerPosition);
    }
}