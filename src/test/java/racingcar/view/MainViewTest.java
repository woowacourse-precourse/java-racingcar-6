package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import racingcar.common.Convert;

class MainViewTest {

    @Test
    void 올바른_시도회수_입력() {
        String correctInput = "5";
        Integer integer = Convert.stringToInteger(correctInput);
        assertThat(integer).isEqualTo(5);
    }

    @Test
    void 부적절한_시도회수_입력() {
        String wrongInput = "qwe";
        assertThatThrownBy(() -> Convert.stringToInteger(wrongInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
}