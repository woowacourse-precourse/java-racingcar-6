package model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class NameTest {

    @Test
    public void 입력값에_공백이_포함된_경우_예외_발생() {
        String input = " pobi";
        assertThatThrownBy(() -> new Name(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력은 공백이 포함될 수 없습니다.");
    }

    @Test
    public void 입력값이_공백인_경우_예외_발생() {
        String input = "";
        assertThatThrownBy(() -> new Name(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력은 공백일 수 없습니다.");
    }

    @Test
    public void 입력값이_5자를_초과하는_경우_예외_발생() {
        String input = "#4abc3";
        assertThatThrownBy(() -> new Name(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력은 5자 이하여야 합니다.");
    }


}
