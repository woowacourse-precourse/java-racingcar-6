package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MoveCountTest {

    @Test
    public void moveCount가_0_이하면_예외를_발생시킨다() throws Exception {
        // given
        int moveCount = -1;

        // when
        //then
        Assertions.assertThatThrownBy(() -> {
            new MoveCount(moveCount);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}