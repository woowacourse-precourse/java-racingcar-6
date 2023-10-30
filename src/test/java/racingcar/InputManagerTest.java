package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class InputManagerTest {

    @Test
    void 정상_동작_테스트() {
        List<String> carNames = InputManager.getCarNames("aaa,bbb");
        assertThat(carNames).contains("aaa", "bbb");
    }

    @Test
    void 마지막_글자가_콤마이면_예외_테스트(){
        assertThatThrownBy(() -> InputManager.getCarNames("name,"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}