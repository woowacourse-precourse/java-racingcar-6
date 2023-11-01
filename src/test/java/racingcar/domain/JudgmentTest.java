package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JudgmentTest {
    List<Car> entry;
    Judgment judgment;

    @BeforeEach
    void setUp() {
        entry = Arrays.asList(new Car("oh"), new Car("kim"), new Car("lee"));
        judgment = new Judgment();
    }

    @Test
    void 경주_결과에_따른_거리측정1() {
        int previous = entry.get(2).distanceMoved;
        judgment.decideMovement(entry);
        int after = entry.get(2).distanceMoved;
        assertThat(previous + after).isBetween(0, 1);
    }

    @Test
    void 경주_결과에_따른_거리측정2() {
        entry.get(1).goForward();
        entry.get(1).goForward();
        int previous = entry.get(1).distanceMoved;
        judgment.decideMovement(entry);
        int after = entry.get(1).distanceMoved;
        assertThat(previous + after).isBetween(4, 5);
    }
}