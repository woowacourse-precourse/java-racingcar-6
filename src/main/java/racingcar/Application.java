package racingcar;

import view.InputView;

public class Application {
    public static void main(String[] args) {

        String[] inputCarNames = InputView.inputCarNames();

        for (int i = 0; i < inputCarNames.length; i++) {
            System.out.println(inputCarNames[i]);
        }
    }
}
