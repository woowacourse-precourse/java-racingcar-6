package racingcar.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class ConsoleInput implements Input{

    @Override
    public List<String> inputRacingCarNames() {
        String racingCarNamesInput = Console.readLine();
        List<String> carNames = Arrays.stream(racingCarNamesInput.split(","))
                .map(String::trim)
                .toList();

        for (String carName : carNames) {
            validateCarNameLength(carName);
        }
        return carNames;
    }

    @Override
    public int inputMovementForwardCount() {
        String movementForwardCountInput = Console.readLine();
        validateIsNumber(movementForwardCountInput);
        return Integer.parseInt(movementForwardCountInput);
    }

    private void validateCarNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
    }

    private void validateIsNumber(String movementForwardCountInput) {
        if (!movementForwardCountInput.matches("^[1-9][0-9]*$")) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }
}
