package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ValidateInputTest {

    @Test
    void input이_없으면_IllegalStateException() {
        String input = "";
        assertThatThrownBy(() ->
                ValidateInput.isRightInput(input)).isInstanceOf(IllegalStateException.class);
    }

    @Test
    void 이름에_중복이_있으면_IllegalStateException() {
        String[] names = new String[]{"name", "name"};
        assertThatThrownBy(() ->
                ValidateInput.isRightCarNames(names)).isInstanceOf(IllegalStateException.class);
    }

    @Test
    void 이름의_길이범위를_초과하면_IllegalStateException() {
        String[] names = new String[]{"longer"};
        assertThatThrownBy(() ->
                ValidateInput.isRightCarNames(names)).isInstanceOf(IllegalStateException.class);
    }
}