package racingcar.impormation;

import java.util.StringJoiner;

public class RacingCar {

    public enum ErrorMessage {
        LONG_CAR_NAME("자동차 이름이 5글자를 초과합니다.");
        private final String message;
        ErrorMessage(final String message) {
            this.message = message;
        }
        public String getMessage() {
            return message;
        }
    }

    private final String name;

    public RacingCar(final String name) {
        final String trimmedName = name.trim();
        inputlength(trimmedName);
        this.name = trimmedName;
    }

    private void inputlength(final String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(ErrorMessage.LONG_CAR_NAME.getMessage());
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", RacingCar.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .toString();
    }
}
