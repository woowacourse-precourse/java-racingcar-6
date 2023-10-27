package racingcar.exception;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class NameExceptionTest {
    @Test
    void 이름_0개() {
        String input = ",";
        String[] names = input.split(",");

        assertThatThrownBy(() -> NameException.validation(names))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> NameException.validation(names))
                .hasMessage("이름은 최소 1글자 이상(공백 제외) 입력해 주세요.");
    }

    @Test
    void 이름_글자수_0개() {
        String input = "";
        String[] names = input.split(",");

        assertThatThrownBy(() -> NameException.validation(names))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> NameException.validation(names))
                .hasMessage("이름은 최소 1글자 이상(공백 제외) 입력해 주세요.");
    }

    @Test
    void 이름_글자수_5개_초과() {
        String input = "winner, gogogo";
        String[] names = input.split(",");

        assertThatThrownBy(() -> NameException.validation(names))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> NameException.validation(names))
                .hasMessage("이름은 5자 이하만 입력 가능합니다.");
    }

    @Test
    void 이름_공백() {
        String input = "    ,   ,  ";
        String[] names = input.split(",");

        assertThatThrownBy(() -> NameException.validation(names))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> NameException.validation(names))
                .hasMessage("이름은 최소 1글자 이상(공백 제외) 입력해 주세요.");
    }
}