package racingcar.game.validator.constants;

public enum ValidatorConstants {
    MAX_LENGTH_OF_CAR_NAME(5);

    final int value;

    ValidatorConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
