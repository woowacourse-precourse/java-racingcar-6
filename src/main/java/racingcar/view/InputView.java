package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {
    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String CAR_NAME_DELIMITER = ",";
    private static final String INPUT_ATTEMPT_NUMBER_MESSAGE = "시도할 횟수는 몇회인가요?";
    private static final String ATTEMPT_TIME_NOT_NUMBER_ERROR = "시도 횟수는 숫자를 입력해야 합니다.";

    public List<String> inputCarNames() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
        String inputCarNames = Console.readLine();
        return List.of(inputCarNames.split(CAR_NAME_DELIMITER));
    }

    public int inputTotalMoveNumber() {
        System.out.println(INPUT_ATTEMPT_NUMBER_MESSAGE);
        String inputTotalMoveNumber = Console.readLine();
        try {
            return Integer.parseInt(inputTotalMoveNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ATTEMPT_TIME_NOT_NUMBER_ERROR);
        }
    }
}
