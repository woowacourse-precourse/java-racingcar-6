package racingcar.domain;

import java.util.Objects;

public class Round {

    private final int round;
    
    public Round(int round) {
        validate(round);
        this.round = round;
    }

    private void validate(int round) {
        if (round < 1) {
            throw new IllegalArgumentException("횟수는 0보다 커야 합니다.");
        }
    }

    public int getRound() {
        return round;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Round round1 = (Round) object;
        return getRound() == round1.getRound();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRound());
    }

}
