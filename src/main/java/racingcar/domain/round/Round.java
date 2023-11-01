package racingcar.domain.round;

import java.util.Objects;

public class Round {

    private int round;

    public Round(int round) {
        this.round = round;
    }

    public boolean isLeft() {
        round--;
        return round >= 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Round round = (Round) o;
        return this.round == round.round;
    }

    @Override
    public int hashCode() {
        return Objects.hash(round);
    }
}
