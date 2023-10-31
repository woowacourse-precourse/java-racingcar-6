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
    private String name;
    private Integer position;

    private Car(String name) {
        validateName(name);
        this.name = name;
        this.position = 0;
    }

    public static Car of(String name) {
        return new Car(name);
    }

    public String getName() {
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

    @Override
    public String toString() {
        return name + RESULT_TOKEN.getSymbol() + RESULT_POSITION.getSymbol().repeat(position);
    }

    public boolean isSamePosition(Integer position) {
        return this.position == position;
    }

    private void move() {
        this.position++;
    }

    private boolean isQualified(Integer randomNumber) {
        return randomNumber >= MIN_FORWARD_THRESHOLD.getValue();
    }

    private void validateName(String name) {
        validateLength(name);
        validateCharacters(name);
    }

    private void validateLength(String name) {
        if (isLengthExceeded(name)) {
            throw RaceException.of(INVALID_NAME_LENGTH);
        }
    }

    private boolean isLengthExceeded(String name) {
        return name.length() > MAX_LENGTH_OF_NUMBER.getValue();
    }

    private void validateCharacters(String name) {
        if (containsInvalidCharacters(name)) {
            throw RaceException.of(INVALID_NAME_CHARACTERS);
        }
    }

    private boolean containsInvalidCharacters(String name) {
        return !name.matches("[a-zA-Z]+");
    }
}
