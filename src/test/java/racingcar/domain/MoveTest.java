package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MoveTest {

    @Test
    void increase_정상_동작_테스트() {
        Move move = new Move();
        move.increase();
        move.increase();

        String moveValue = move.toString();
        int expectedValue = 2;
        int actualValue = moveValue.length();

        Assertions.assertThat(expectedValue).isEqualTo(actualValue);
    }
}