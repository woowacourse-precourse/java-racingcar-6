package racingcar;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        String cars = inputView.inputCars();
        int number = inputView.inputNumber();

        outputView.gameResult();
    }
}