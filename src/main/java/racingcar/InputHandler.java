package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Objects;

public class InputHandler {

    public Cars inputName() {
        return new Cars(Console.readLine());
    }

    public int inputRound() {
        String input = Console.readLine();
        validateRound(input);
        return Integer.parseInt(input);
    }

    private void validateRound(String input) {
        if (Objects.equals(input, "")) {
            throw new IllegalArgumentException("어떠한 것도 입력되지 않았습니다! 값을 입력해주세요!");
        }

        if (!input.matches("^[0-9]*$")) {
            throw new IllegalArgumentException("입력에 숫자가 아닌 다른 문자가 포함되어 있습니다!");
        }
    }
}
