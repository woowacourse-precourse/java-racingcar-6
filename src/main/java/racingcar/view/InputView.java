package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;
import racingcar.enums.ErrorMessages;

public class InputView {
    public String readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        return input;
    }

    public int readCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        validateCount(input);
        return Integer.parseInt(input);
    }

    private void validateCount(String input) {
        if (!Pattern.matches("^[0-9]*$", input)) {
            throw new IllegalArgumentException(ErrorMessages.ONLY_NUMBER.getMessage());
        }
    }
}
