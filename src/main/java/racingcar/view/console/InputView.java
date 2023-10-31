package racingcar.view.console;

import racingcar.view.console.util.InputUtil;

public class InputView {
    private static final String ENTER_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ENTER_RACE_ATTEMPTS_MESSAGE = "시도할 회수는 몇회인가요?";

    public String readCarNames() {
        System.out.println(ENTER_CAR_NAMES_MESSAGE);
        return InputUtil.readNonEmptyLineInput();
    }

    public int readRaceAttempts() {
        System.out.println();
        System.out.println(ENTER_RACE_ATTEMPTS_MESSAGE);
        return InputUtil.readNaturalInt();
    }
}
