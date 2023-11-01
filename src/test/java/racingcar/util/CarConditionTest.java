package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CarConditionTest {
    CarCondition carCondition = new CarCondition();

    @Test
    void 랜덤_숫자_생성() {
        assertThat(carCondition.makeRandom()).isBetween(0, 9);
    }

    @Test
    void 랜덤_숫자가_4이상이면_true_아니면_false_전달() {
        int seed = 0;
        assertThat(carCondition.isMove(seed)).isFalse();
    }
}
