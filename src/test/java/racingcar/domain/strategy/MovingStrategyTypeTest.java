package racingcar.domain.strategy;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class MovingStrategyTypeTest {
    @Test
    void 인스턴스_요청_시_주어진_타입에_맞는_인스턴스가_반환된다() {
        MovingStrategy instance = MovingStrategyType.instance(MovingStrategyType.RANDOM);

        assertThat(instance).isInstanceOf(RandomMovingStrategy.class);
    }
}
