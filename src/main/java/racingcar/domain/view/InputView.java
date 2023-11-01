package racingcar.domain.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_ATTEMPT_NUMBER_MESSAGE = "시도할 회수는 몇회인가요?";

    public static String inputCarNameList() {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
        return getReadLine();
    }

    public static String inputAttemptNumber() {
        System.out.println(INPUT_ATTEMPT_NUMBER_MESSAGE);
        return getReadLine();
    }

    private static String getReadLine() {
        return Console.readLine();
    }
}