package racingcar.domain;

import static racingcar.global.constants.NumberType.INITIAL_POSITION;
import static racingcar.global.constants.NumberType.MIN_FORWARD_THRESHOLD;
import static racingcar.global.constants.SymbolType.RESULT_POSITION;
import static racingcar.global.constants.SymbolType.RESULT_TOKEN;

import racingcar.utils.RandomUtils;

public class Car {
    private Name name;
    private Integer position;

    private Car(final String name) {
        this.name = Name.of(name);
        this.position = INITIAL_POSITION.getValue();
    }

    public static Car of(final String name) {
        return new Car(name);
    }

    public String getName() {
        return this.name.getValue();
    }

    public Integer getPosition() {
        return this.position;
    }

    public boolean isSamePosition(final Integer position) {
        return this.position == position;
    }

    public void tryMove() {
        Integer randomNumber = RandomUtils.generateRandomNumber();
        if (isQualified(randomNumber)) {
            move();
        }
    }

    @Override
    public String toString() {
        return name.getValue() + RESULT_TOKEN.getSymbol() + RESULT_POSITION.getSymbol().repeat(position);
    }

    private boolean isQualified(final Integer randomNumber) {
        return randomNumber >= MIN_FORWARD_THRESHOLD.getValue();
    }

    private void move() {
        this.position++;
    }
}
