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
        return convertInputCarNamesToList(inputCarNames);
    }

    public int askTryCount() {
        System.out.println(QUESTION_TRY_COUNT);
        String inputTryCount = Console.readLine();
        return convertInputTryCountToInt(inputTryCount);
    }

    private List<String> convertInputCarNamesToList(String inputCarNames) {
        List<String> carNames = Arrays.stream(inputCarNames.split(","))
                .map(String::trim)
                .peek(this::checkCarNameNotEmpty)
                .toList();
        checkCarNamesNotEmpty(carNames);
        return carNames;
    }

    private void checkCarNameNotEmpty(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 앞뒤 공백을 제외한 1자 이상으로 입력해야 합니다.");
        }
    }

    private void checkCarNamesNotEmpty(List<String> carNames) {
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 하나 이상 입력해야 합니다.");
        }
    }

    private int convertInputTryCountToInt(String inputTryCount) {
        try {
            return Integer.parseInt(inputTryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 횟수는 정수로 입력해야 합니다.");
        }
    }
}
