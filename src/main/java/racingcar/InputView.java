package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final static String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 시준으로 구분)";
    private final static String INPUT_TRY_NUMBER_MESSAGE = "시도할 회수는 몇회인가요?";

    public static String inputCarNames() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
        return Console.readLine();
    }

    public static String inputTryNumber() {
        System.out.println(INPUT_TRY_NUMBER_MESSAGE);
        return Console.readLine();
    }
}
