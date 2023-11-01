package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.InvalidCustomException;

public class RacingGameInputView {
    public static String[] getCarNames() {
        return validateInput("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,)로 구분)").split(",");
    }

    public static int getTotalAttempts() {
        return Integer.parseInt(validateInput("시도할 회수는 몇 회인가요?"));
    }

    private static String validateInput(String message) {
        System.out.println(message);
        String input = Console.readLine();
        if (input.isEmpty()) {
            throw new InvalidCustomException("입력 값이 없습니다.");
        }
        return input;
    }
}
