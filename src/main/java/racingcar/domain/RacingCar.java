package racingcar.domain;

import java.util.Objects;

public class RacingCar {

    private static final int RACINGCAR_NAME_MAX_COUNT = 5;
    private final String name;
    private final int moveCount;

    private RacingCar(final String name, int moveCount) {
        validationNull(name);
        validationNameCount(name);
        this.name = name;
        this.moveCount = moveCount;
    }

    public static RacingCar of(final String name, int moveCount) {
        return new RacingCar(name, moveCount);
    }

    public int getMoveCount() {
        return moveCount;
    }

    public String getName() {
        return name;
    }

    private static void validationNull(String input) {
        if (Objects.isNull(input) || input.length() == 0) {
            throw new IllegalArgumentException("자동차의 이름은 필수입니다.");
        }
    }

    private static void validationNameCount(String name) {
        if (name.length() > RACINGCAR_NAME_MAX_COUNT) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }
    }

    public RacingCar move(int moveCount) {
        if(!validationMove(moveCount)) {
            return this;
        }
        return RacingCar.of(this.name, this.moveCount + moveCount);
    }

    private boolean validationMove(int moveCount) {
        if (moveCount < 4) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.name);
        builder.append(" : ");
        for(int i = 0; i < this.moveCount; i++) {
            builder.append("-");
        }
        return builder.toString();
    }
}
