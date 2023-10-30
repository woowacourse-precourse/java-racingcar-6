package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final String QUESTION_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String QUESTION_TRY_COUNT = "시도할 회수는 몇회인가요?";

    public List<String> askCarNames() {
        System.out.println(QUESTION_CAR_NAMES);
        String inputCarNames = Console.readLine();
        return Arrays.stream(inputCarNames.split(",")).toList();
    }

    public int askTryCount() {
        System.out.println(QUESTION_TRY_COUNT);
        String inputTryCount = Console.readLine();
        return convertInputTryCountToInt(inputTryCount);
    }

    private int convertInputTryCountToInt(String inputTryCount) {
        try {
            return Integer.parseInt(inputTryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 횟수는 정수여야 합니다.");
        }
    }
}
