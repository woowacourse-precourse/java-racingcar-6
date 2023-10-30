package racingcar.util;

import racingcar.domain.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;

public class GamePlay {
    InputView inputView;
    OutputView outputView;
    GameUtil gameUtil;

    public GamePlay() {
        inputView = new InputView();
        outputView = new OutputView();
        gameUtil = new GameUtil();
    }

    public void gamePlay() {
        String carName = inputView.inputCars();
        int count = inputView.inputCount();

        outputView.gameStart();

        ArrayList<Car> carArrayList = gameUtil.splitNameArrayList(carName);

        for (int i = 0; i < count; i++) {
            gameUtil.goAndStop(carArrayList);
            outputView.gameSituation(carArrayList);
            System.out.println();
        }

        String winner = gameUtil.winner(carArrayList);
        outputView.winner(winner);
    }
}
