package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String readInput() {
        return Console.readLine();
    }

    public String readCarNames() {
        String carNames = Console.readLine();
        validateCarNames(carNames);
    }

    private void validateCarNames(String carNames) {
        validateBlankInput(carNames);
    }

    private void validateBlankInput(String carNames) {
        if (carNames.isBlank()) {
            throw new IllegalArgumentException("공백이 입력되었습니다.");
        }
    }
}
