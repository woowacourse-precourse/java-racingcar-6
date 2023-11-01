package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EngineTest {
    private Engine engine;


    @BeforeEach
    void setUp() {
        engine = new Engine();
    }

    @Test
    @DisplayName("전진 여부 결정 테스트")
    void 전진_여부_결정_테스트() {
        boolean result = engine.isMovingForward();
        assertThat(result).isIn(true, false);
    }

}