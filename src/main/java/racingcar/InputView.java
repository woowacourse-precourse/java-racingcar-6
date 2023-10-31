package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.ExceptionMessage.INPUT_TYPE_MISMATCH;

public class InputView {
    private static final String CAR_NAME_REQUEST = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TIMES_TO_TRY_REQUEST = "시도할 횟수는 몇회인가요?";
    private static final String INT_TYPE = "-?\\d+";

    public static String carNames() {
        System.out.println(CAR_NAME_REQUEST);
        String carNamesString;
        carNamesString = readLine();
        return carNamesString;
    }

    public static int timesToTry() {
        System.out.println(TIMES_TO_TRY_REQUEST);
        String inputString = readLine();
        checkInputIsInteger(inputString);
        return Integer.parseInt(inputString);
    }

    private static void checkInputIsInteger(String inputString) {
        if (!inputString.matches(INT_TYPE)) {
            throw new IllegalArgumentException(INPUT_TYPE_MISMATCH);
        }
    }
}
