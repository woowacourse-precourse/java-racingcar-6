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
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("마지막 글자가 콤마가 될 수 없습니다!");
    }

    @Test
    void 자동차_이름의_길이_예외_테스트(){
        assertThatThrownBy(() -> InputManager.getCarNames("name,123456"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 이름은 1글자 이상 5글자 이하여야 합니다.");
    }
}