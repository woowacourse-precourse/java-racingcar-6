package racingcar;

import java.util.Arrays;
import java.util.List;

public class Validation {
    private static final Integer CAR_NAME_MAX_LENGTH = 5;
    private static final String OVER_MAX_LENGTH_MESSAGE = String.format("자동차 이름은 %d자 이하로 입력해주세요.", CAR_NAME_MAX_LENGTH);
    private static final String DUPLICATE_MESSAGE = "자동차 이름이 중복되지 않게 입력해주세요.";
    private static final String NOT_NATURAL_NUMBER_MESSAGE = "자연수를 입력해주세요.";
    private List<String> carNames;
    private String roundCount;

    public List<String> formatCarNames(String carNames) {
        this.carNames = Arrays.stream(carNames.split(",")).toList();

        if (this.isOverMaxLength()) {
            throwException(OVER_MAX_LENGTH_MESSAGE);
        }
        if (this.isDuplicate()) {
            throwException(DUPLICATE_MESSAGE);
        }

        return this.carNames;
    }

    public Integer formatRoundCount(String roundCount) {
        this.roundCount = roundCount;

        if (this.isNotNaturalNumber()) {
            throwException(NOT_NATURAL_NUMBER_MESSAGE);
        }

        return Integer.parseInt(roundCount);
    }

    private Boolean isDuplicate() {
        return this.carNames.size() != this.carNames.stream().distinct().count();
    }

    private Boolean isOverMaxLength() {
        return this.carNames.stream().anyMatch(carName -> carName.length() > CAR_NAME_MAX_LENGTH);
    }

    private Boolean isNotNaturalNumber() {
        try {
            return Integer.parseInt(this.roundCount) <= 0;
        } catch (NumberFormatException exception) {
            return true;
        }
    }

    private void throwException(String message) {
        throw new IllegalArgumentException(message);
    }
}
