package racingcar.domain;

public class CarName {
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final String AVAILABLE_CHARACTER_REGEX = "[a-zA-Z0-9가-힣]*";
    private static final String MAX_CAR_NAME_EXCEPTION = "자동차 이름은 최소 1자 이상 최대 5자 이하만 가능합니다.";
    private static final String AVAILABLE_CHARACTER_EXCEPTION = "자동차 이름은 한글, 영어, 숫자만 가능합니다.";
    private final String name;

    public CarName(String name) {
        validateLength(name);
        validateCharacter(name);
        this.name = name;
    }

    private void validateLength(String carName) {
        if (carName.isEmpty() || carName.isBlank() || MAX_CAR_NAME_LENGTH < carName.length()) {
            throw new IllegalArgumentException(MAX_CAR_NAME_EXCEPTION);
        }
    }

    private void validateCharacter(String carName) {
        if (!carName.matches(AVAILABLE_CHARACTER_REGEX)) {
            throw new IllegalArgumentException(AVAILABLE_CHARACTER_EXCEPTION);
        }
    }

    public String getName() {
        return this.name;
    }
}
