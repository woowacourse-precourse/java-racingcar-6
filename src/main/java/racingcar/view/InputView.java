package racingcar.view;

import java.util.List;
import racingcar.config.GameConfig;
import racingcar.util.InputUtil;

public final class InputView {

    private static final String INPUT_CAR_NAMES_REQUEST_MESSAGE = String.format(
            "경주할 자동차 이름을 입력하세요.(이름은 %s(%s) 기준으로 구분)",
            GameConfig.CAR_NAME_DELIMITER_KR,
            GameConfig.CAR_NAME_DELIMITER
    );
    private static final String INPUT_NUMBER_OF_ATTEMPTS_REQUEST_MESSAGE = "시도할 회수는 몇회인가요?";

    private InputView() {
    }

    public static List<String> readCarNames() {
        System.out.println(INPUT_CAR_NAMES_REQUEST_MESSAGE);
        return InputUtil.readStringList();
    }

    public static int readNumberOfAttempts() {
        System.out.println(INPUT_NUMBER_OF_ATTEMPTS_REQUEST_MESSAGE);
        return InputUtil.readInt();
    }
}
