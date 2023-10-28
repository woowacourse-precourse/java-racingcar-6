package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class InputView {

    private static final String NUMBER_PATTERN = "^[\\d]*$";
    private static final String ZERO = "0";

    public static String[] inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine().split(",");
    }

    public static int inputRoundNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        validateIsNumber(input);
        validateIsNotZero(input);
        int roundNumber = Integer.parseInt(input);
        return roundNumber;
    }

    private static void validateIsNumber(String input) {
        if (!Pattern.matches(NUMBER_PATTERN, input)) {
            throw new IllegalArgumentException("자연수만 입력 가능합니다.");
        }
    }

    private static void validateIsNotZero(String input) {
        if (input.equals(ZERO)) {
            throw new IllegalArgumentException("자연수만 입력 가능합니다.");
        }
    }
}
