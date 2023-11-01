package racingcar.game.validator.constants;

public enum ValidatorIntegerConstants {
    MAX_LENGTH_OF_CAR_NAME(5);

    final int value;

    ValidatorIntegerConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
