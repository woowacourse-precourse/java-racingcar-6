package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class FixedCarEngineTest {

    @Test
    void startTest() {
        FixedCarEngine fixedCarEngine = new FixedCarEngine();
        boolean canMove = fixedCarEngine.start();
        boolean cantMove = fixedCarEngine.stop();
        assertThat(canMove).isTrue();
        assertThat(cantMove).isFalse();
    }
}
