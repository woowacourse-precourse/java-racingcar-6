package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Objects;
import java.util.function.BooleanSupplier;
import java.util.function.IntSupplier;

class CarRandomMovingStrategy implements BooleanSupplier {

    private static final int RANDOM_MIN_NUMBER = 0;
    private static final int RANDOM_MAX_NUMBER = 9;
    private static final int MIN_NUMBER_WHEN_MOVING = 4;
    private static final IntSupplier DEFAULT_RANDOM_NUMBER_GENERATOR
            = () -> Randoms.pickNumberInRange(RANDOM_MIN_NUMBER, RANDOM_MAX_NUMBER);

    private final IntSupplier randomNumberGenerator;

    private CarRandomMovingStrategy(IntSupplier randomNumberGenerator) {
        this.randomNumberGenerator = Objects.requireNonNull(randomNumberGenerator);
    }

    static CarRandomMovingStrategy create() {
        return new CarRandomMovingStrategy(DEFAULT_RANDOM_NUMBER_GENERATOR);
    }

    static CarRandomMovingStrategy from(IntSupplier randomNumberGenerator) {
        return new CarRandomMovingStrategy(randomNumberGenerator);
    }

    @Override
    public boolean getAsBoolean() {
        int randomNumber = randomNumberGenerator.getAsInt();
        validate(randomNumber);

        return randomNumber >= MIN_NUMBER_WHEN_MOVING;
    }

    private void validate(int randomNumber) {
        if (!isValidate(randomNumber)) {
            throw new IllegalArgumentException("움직임을 판단하는데 문제가 생겼습니다, 랜덤 값 : " + randomNumber);
        }
    }

    private boolean isValidate(int randomNumber) {
        return RANDOM_MIN_NUMBER <= randomNumber && randomNumber <= RANDOM_MAX_NUMBER;
    }
}
