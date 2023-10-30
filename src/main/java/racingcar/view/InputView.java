package racingcar.view;

import java.util.Arrays;
import java.util.function.Supplier;

public class InputView {
    private static final String CAR_NAMES_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)";
    private static final String BLANK_EXCEPTION_MESSAGE = "Error: 입력은 공백이거나 비어있을 수 없습니다.";
    private static final String CAR_NAMES_DELIMITER = ",";

    private final Supplier<String> reader;

    public InputView(Supplier<String> reader) {
        this.reader = reader;
    }

    public String readCarNames() {
        System.out.println(CAR_NAMES_INPUT_MESSAGE);
        String carNames = reader.get();

        validateIsBlank(carNames);

        return carNames;
    }

    private void validateIsBlank(String string) {
        if (string.isBlank()) {
            throw new IllegalArgumentException(BLANK_EXCEPTION_MESSAGE);
        }
    }
}
