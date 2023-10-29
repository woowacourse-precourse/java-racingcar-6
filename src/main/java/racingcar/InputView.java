package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {
    static final String CAR_NAMES_REQUEST_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    static final String COMMA = ",";
    static final String ATTEMPTS_REQUEST_MESSAGE = "시도할 회수는 몇회인가요?";

    public static String inputCarNames() {
        System.out.println(CAR_NAMES_REQUEST_MESSAGE);
        return Console.readLine();
    }

    public static List<String> divideCarNames(String carNames) {
        String[] dividedCarNames = carNames.split(COMMA);
        return new ArrayList<>(Arrays.asList(dividedCarNames));
    }

    public static String inputAttempts() {
        System.out.println(ATTEMPTS_REQUEST_MESSAGE);
        return Console.readLine();
    }
}
