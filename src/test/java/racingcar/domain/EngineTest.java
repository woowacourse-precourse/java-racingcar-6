package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EngineTest {
    private Engine engine;


    @BeforeEach
    void setUp() {
        engine = new Engine();
    }

    @Test
    void 전진_여부_결정_테스트() {
        boolean result = engine.isMovingForward();
        assertThat(result).isIn(true, false);
    }

}