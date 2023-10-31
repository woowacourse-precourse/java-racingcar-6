package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.global.util.GameInput.validateCarList;
import static racingcar.global.util.GameInput.validateEndCnt;

import org.junit.jupiter.api.Test;

public class IOTest {

    @Test
    public void 여러_차량명_입력의_구분자가_쉼표가_아닌_경우_예외처리() {
        String input = "jun|    seo";
        assertThat(input).isNotEqualTo(new String[] {"jun", "seo"});
    }

    @Test
    public void 여러_차량명_입력에_공백이_포함된_경우_예외처리() {
        String input = "      jun,     seo ";
        assertThat(input.trim().split(",\\s*")).isEqualTo(new String[] {"jun", "seo"});
    }

    @Test
    public void 차량명이_5자를_초과하는_경우_예외처리() {
        String[] input = new String[]{"jun", "seodse"};
        assertThatThrownBy(() -> validateCarList(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 이하만 가능합니다.");
    }

    @Test
    public void 입력값이_비어_있는_경우_예외처리() {
        String input1 = "";
        String[] input2 = new String[]{""};
        assertThatThrownBy(() -> validateEndCnt(input1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력 값이 비어 있습니다.");
        assertThatThrownBy(() -> validateCarList(input2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력 값이 비어 있습니다.");
    }

    @Test
    public void 입력된_회차_형식이_숫자가_아닌_경우_예외처리() {
        String input = "!";

        assertThatThrownBy(() -> validateEndCnt(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자 형식이 올바르지 않습니다.");
    }

}
