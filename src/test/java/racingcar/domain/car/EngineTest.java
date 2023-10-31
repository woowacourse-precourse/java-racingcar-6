package racingcar.domain.car;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class EngineTest {

    @Test
    void 랜덤값이_4_이상일_경우_TRUE_반환() {
        assertRandomNumberInRangeTest(
                () -> {
                    Engine engine = new Engine();
                    assertThat(engine.isForward()).isTrue();
                },
                4
        );
    }

    @Test
    void 랜덤값이_4_미만일_경우_FALSE_반환() {
        assertRandomNumberInRangeTest(
                () -> {
                    Engine engine = new Engine();
                    assertThat(engine.isForward()).isFalse();
                },
                3
        );
    }

}
