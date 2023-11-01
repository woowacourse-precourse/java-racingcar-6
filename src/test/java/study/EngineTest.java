package study;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.domain.Engine;

public class EngineTest {

    @Test
    void createRandomMethod_메서드_사용시_0에서_9사이의_값만_생성된다() {
        Engine engine = new Engine();
        for (int i = 0; i < 1000; i++) {
            int randomNumber = engine.createRandomNumber();
            assertThat(randomNumber >= 0 && randomNumber <= 9).isEqualTo(true);
        }
    }
}
