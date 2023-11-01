package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final InputView instance = new InputView();

    public InputView() {
    }

    public static InputView getInstance() {
        return instance;
    }

    public static String inputCarNames() {
        System.out.println(Message.INPUT_MAIN_MESSAGE.message);
        return Console.readLine();
    }

    public static String inputTryNumber() {
        System.out.println(Message.INPUT_TRY_MESSAGE.message);
        return Console.readLine();
    }

    private enum Message {
        INPUT_MAIN_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
        INPUT_TRY_MESSAGE("시도할 회수는 몇회인가요?");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }
}
