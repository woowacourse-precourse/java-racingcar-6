package racingcar;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumInputTest {

    @Test
    void 횟수에_숫자형_외_입력_시__예외테스트() {
        assertThatThrownBy(() -> {
            String gameNum = "a";
            InputNumCheck.numCheck(gameNum);
        })
                .isInstanceOf(IllegalArgumentException.class);
    }
}
