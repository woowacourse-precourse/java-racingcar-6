package racingcar;

import camp.nextstep.edu.missionutils.Console;
import org.junit.platform.commons.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {

    public static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String NUMBER_OF_ATTEMPTS_MESSAGE = "시도할 회수는 몇회인가요?";
    public static final String INVALID_CAR_NAME_EMPTY_MESSAGE = "자동차 이름이 입력되지 않았습니다.";
    public static final String INVALID_CAR_NAME_MESSAGE = "띄어쓰기 없이 작성하시오.";
    public static final String INVALID_CAR_NAME_LENGTH_MESSAGE = "자동차 이름은 5자 이하여야 합니다.";

    public static void main(String[] args) {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
        String inputCarNames = Console.readLine();

        validateInputCarName(inputCarNames);

        List<String> carNames = getCarNames(inputCarNames);

        System.out.println(NUMBER_OF_ATTEMPTS_MESSAGE);
        int numberOfAttempts = Integer.parseInt(Console.readLine());
    }

    public static void validateInputCarName(String inputCarNames) {
        List<String> carNames = getCarNames(inputCarNames);
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_EMPTY_MESSAGE);
        }
        if (StringUtils.containsWhitespace(inputCarNames)) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_MESSAGE);
        }
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException(INVALID_CAR_NAME_LENGTH_MESSAGE);
            }
        }
    }

    public static List<String> getCarNames(String inputCarNames) {
        String[] split = inputCarNames.split(",");
        List<String> carNames = new ArrayList<>(Arrays.asList(split));
        return carNames;
    }
}