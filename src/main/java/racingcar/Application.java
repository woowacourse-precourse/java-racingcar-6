package racingcar;

import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input = InputView.inputName();
        System.out.println(input);

        String input1 = InputView.inputAttempt();
        System.out.println(input1);
    }
}
