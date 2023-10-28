package racingcar.domain;

import racingcar.domain.generator.NumberGenerator;
import racingcar.domain.generator.RandomNumberGenerator;
import racingcar.exception.ErrorMessage;
import racingcar.exception.InvalidInputException;

public class RacingCar {
    public static final int NAME_MIN_LENGTH = 1;
    public static final int NAME_MAX_LENGTH = 5;
    public static final int MIN_FORWARD_THRESHOLD = 4;

    private final String name;
    private final NumberGenerator numberGenerator;
    private int position = 0;

    public RacingCar(String name, NumberGenerator numberGenerator) {
        validateNameLength(name);
        this.name = name;
        this.numberGenerator = numberGenerator;
    }

    public RacingCar(String name) {
        this(name, new RandomNumberGenerator());
    }

    private void validateNameLength(String name) {
        if (name.length() < NAME_MIN_LENGTH || name.length() > NAME_MAX_LENGTH) {
            throw new InvalidInputException(ErrorMessage.INVALID_CAR_NAME_LENGTH);
        }
    }

    public void moveOrStop() {
        if (shouldMove()) {
            position++;
        }
    }

    public boolean shouldMove() {
        return numberGenerator.generate() >= MIN_FORWARD_THRESHOLD;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
