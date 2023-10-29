package model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RandomMoveTest {

    @Test
    void 랜덤_전진() {
        RandomMove randomMove = new RandomMove();
        Assertions.assertThat(randomMove.isMove()).isTrue();
    }
}
