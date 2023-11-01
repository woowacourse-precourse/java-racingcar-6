package racingcar.domain.car;

import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

class EngineTest {

    @RepeatedTest(1_000)
    void 랜덤_번호_생성_범위_테스트() {
        // given
        final Engine engine = Engine.newInstance();
        final int MAX_VALUE = 9;
        final int MIN_VALUE = 0;

        // when
        int number = engine.pressAccelerator();

        // then
        assertThat(number)
                .isGreaterThanOrEqualTo(MIN_VALUE)
                .isLessThanOrEqualTo(MAX_VALUE)
        ;
    }

}