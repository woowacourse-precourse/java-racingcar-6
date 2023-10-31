package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {

    private static final String REQUEST_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,)를 기준으로 구분).";
    private static final String INVALID_NAME_ERROR_MESSAGE = "이름은 쉼표(,)로 구분되는 최소 한 개 이상의 문자열이어야 합니다.\";";
    private static final String NAME_DELIMITER = ",";
    private static final String TRIAL_COUNT_MESSAGE = "시도할 횟수는 몇회인가요?";
    private static final String NUMBER_REGEX ="^[1-9]\\d*$";
    private static final String INVALID_TRIAL_COUNT_MESSAGE = "시도 횟수는 1 이상의 자연수만 가능합니다.";

    public static List<String> getNames() {
        System.out.println(REQUEST_NAMES_MESSAGE);
        String input = Console.readLine();
        return isValidName(input);
    }

    private static List<String> isValidName(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(INVALID_NAME_ERROR_MESSAGE);
        }
        return splitNames(input);
    }

    private static List<String> splitNames(String input) {
        return List.of(input.split(NAME_DELIMITER));
    }

    public static int getTrialCount() {
        System.out.println(TRIAL_COUNT_MESSAGE);
        String input = Console.readLine();
        return isValidTrialCount(input);
    }

    private static int isValidTrialCount(String input) {
        if(!input.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException(INVALID_TRIAL_COUNT_MESSAGE);
        }
        return Integer.parseInt(input);
    }

}
