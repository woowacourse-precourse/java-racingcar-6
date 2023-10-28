package racingcar;

import racingcar.util.GameUtil;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        GameUtil gameUtil = new GameUtil();

        String cars = inputView.inputCars();
        int count = inputView.inputCount();

        outputView.gameStart();
        gameUtil.gamePlay(cars, count);
    }
}