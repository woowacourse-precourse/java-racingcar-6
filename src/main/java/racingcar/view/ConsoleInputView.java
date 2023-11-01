package racingcar.view;

import racingcar.util.InputUtil;

public class ConsoleInputView implements InputView {

    private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TRY_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";

    @Override
    public String inputCarNames() {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
        return InputUtil.inputString();
    }

    @Override
    public String inputTryCount() {
        System.out.println(INPUT_TRY_COUNT_MESSAGE);
        String tryCount = InputUtil.inputString();
        System.out.println();

        return tryCount;
    }
}
