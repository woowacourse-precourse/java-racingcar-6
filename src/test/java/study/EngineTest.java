package study;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Engine;

@DisplayName("엔진 객체 테스트")
public class EngineTest {

    @DisplayName("성공 : 엔진이 생성하는 무작위 값은 0~9 이다.")
    @Test
    void test1() {
        Engine engine = new Engine();
        for (int i = 0; i < 1000; i++) {
            int randomNumber = engine.createRandomNumber();
            assertThat(randomNumber >= 0 && randomNumber <= 9).isEqualTo(true);
        }
    }
}
