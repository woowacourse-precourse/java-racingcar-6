package racingcar.view;

import java.util.function.Supplier;

public class InputView {
    private static final String CAR_NAMES_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)";
    private static final String EMPTY_EXCEPTION_MESSAGE = "입력은 빈 문자열이 될 수 없습니다.";
    private static final String CAR_NAMES_DELIMITER = ",";
    private static final String EMPTY_STRING = "";

    private final Supplier<String> reader;

    public InputView(Supplier<String> reader) {
        this.reader = reader;
    }

    public String readCarNames() {
        System.out.println(CAR_NAMES_INPUT_MESSAGE);
        String carNames = reader.get();

        validateCarNames(carNames);

        return carNames;
    }

    private void validateCarNames(String carNames) {
        validateIsEmpty(carNames);
    }

    private void validateIsEmpty(String carNames) {
        if (carNames == null || carNames.equals(EMPTY_STRING)) {
            throw new IllegalArgumentException(EMPTY_EXCEPTION_MESSAGE);
        }
    }
}
