package racingcar;

import racingcar.View.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();

        inputView.askForCarNames();
        inputView.askForAttempts();
    }

}
