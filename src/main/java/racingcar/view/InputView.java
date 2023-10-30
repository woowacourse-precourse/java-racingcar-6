package racingcar.view;

import static racingcar.global.constants.SymbolType.DELIMITER;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readInput() {
        return Console.readLine();
    }

    public String readCarNames() {
        String carNames = readInput();
        validateCarNames(carNames);
        return carNames;
    }

    private void validateCarNames(String names) {
        validateBlankInput(names);
        validateInvalidDelimiter(names);
    }

    private void validateBlankInput(String names) {
        if (names.isBlank()) {
            throw new IllegalArgumentException("공백이 입력되었습니다.");
        }
    }

    private void validateInvalidDelimiter(String names) {
        if (isEdgeDelimiter(names) || hasContinuousDelimiters(names)) {
            throw new IllegalArgumentException("쉼표(,)를 올바르게 입력해주세요.");
        }
    }

    private boolean hasContinuousDelimiters(String names) {
        return names.contains(generateContinuousDelimiters());
    }

    private String generateContinuousDelimiters() {
        return DELIMITER.getSymbol().repeat(2);
    }

    private boolean isEdgeDelimiter(String names) {
        return startWithDelimiter(names) || endsWithDelimiter(names);
    }

    private boolean startWithDelimiter(String names) {
        return names.startsWith(DELIMITER.getSymbol());
    }

    private boolean endsWithDelimiter(String names) {
        return names.endsWith(DELIMITER.getSymbol());
    }
}
