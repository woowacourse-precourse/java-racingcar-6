package racingcar.domain;

import racingcar.dto.RoundResponse;

import java.util.Objects;

public class Car {
    private static final Integer START_SCORE = 0;

    private final Name name;
    private Integer score;

    private Car(final String name) {
        this.name = Name.create(name);
        this.score = START_SCORE;
    }

    public static Car create(final String name) {
        return new Car(name);
    }

    public void move() {
        MovementCondition condition = MovementCondition.create();
        if (condition.movable()) {
            score++;
        }
    }

    public RoundResponse generateRoundResponse() {
        return new RoundResponse(name.getName(), score);
    }

    public boolean isSameScore(Integer score) {
        return Objects.equals(this.score, score);
    }

    public String getName() {
        return name.getName();
    }

    public Integer getScore() {
        return score;
    }
}
