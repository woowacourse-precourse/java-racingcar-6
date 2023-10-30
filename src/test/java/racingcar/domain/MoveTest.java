package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MoveTest {

    @Test
    void increaseMove_정상_동작_테스트() {
        Move move = new Move();
        move.increaseMove();
        move.increaseMove();

        String moveValue = move.toString();
        int expectedValue = 2;
        int actualValue = moveValue.length();

        Assertions.assertThat(expectedValue).isEqualTo(actualValue);
    }
}