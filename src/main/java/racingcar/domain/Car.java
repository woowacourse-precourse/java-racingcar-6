package racingcar.domain;

import static racingcar.global.constants.NumberType.MAX_LENGTH_OF_NUMBER;
import static racingcar.global.constants.NumberType.MIN_FORWARD_THRESHOLD;
import static racingcar.global.constants.SymbolType.RESULT_POSITION;
import static racingcar.global.constants.SymbolType.RESULT_TOKEN;
import static racingcar.global.exception.ErrorMessage.INVALID_NAME_CHARACTERS;
import static racingcar.global.exception.ErrorMessage.INVALID_NAME_LENGTH;

import racingcar.global.exception.RaceException;
import racingcar.utils.RandomUtils;

public class Car {
    private Name name;
    private Integer position;

    private Car(final String name) {
        Validator.validateName(name);
        this.name = Name.of(name);
        this.position = 0;
    }

    public static Car of(final String name) {
        return new Car(name);
    }

    public Name getName() {
        return this.name;
    }

    public Integer getPosition() {
        return this.position;
    }

    public void tryMove() {
        Integer randomNumber = RandomUtils.generateRandomNumber();
        if (isQualified(randomNumber)) {
            move();
        }
    }

    private boolean isQualified(final Integer randomNumber) {
        return randomNumber >= MIN_FORWARD_THRESHOLD.getValue();
    }

    private void move() {
        this.position++;
    }

    public boolean isSamePosition(final Integer position) {
        return this.position == position;
    }

    @Override
    public String toString() {
        return name + RESULT_TOKEN.getSymbol() + RESULT_POSITION.getSymbol().repeat(position);
    }

    private static class Validator {
        private static void validateName(final String name) {
            validateLength(name);
            validateCharacters(name);
        }

        private static void validateLength(final String name) {
            if (isLengthExceeded(name)) {
                throw RaceException.of(INVALID_NAME_LENGTH);
            }
        }

        private static boolean isLengthExceeded(final String name) {
            return name.length() > MAX_LENGTH_OF_NUMBER.getValue();
        }

        private static void validateCharacters(final String name) {
            if (containsInvalidCharacters(name)) {
                throw RaceException.of(INVALID_NAME_CHARACTERS);
            }
        }

        private static boolean containsInvalidCharacters(final String name) {
            return !name.matches("[a-zA-Z]+");
        }
    }
}
