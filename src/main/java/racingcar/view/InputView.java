package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_CAR_NAME_MESSAGE = "경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_ROUND_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";

    private InputView() {
    }

    public static String carNamesInput() {
        return input(INPUT_CAR_NAME_MESSAGE);
    }

    public static String roundCountInput() {
        return input(INPUT_ROUND_COUNT_MESSAGE);
    }

    private static String input(String message) {
        System.out.println(message);
        return Console.readLine();
    }
}
