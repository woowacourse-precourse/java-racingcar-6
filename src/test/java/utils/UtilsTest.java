package utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class UtilsTest {
    Utils utils = new Utils();

    @Test
    public void split_구분자를_이용하여_문자열_분리() {
        String input = "pobi,jun,woni";
        String[] expectString = {"pobi", "jun", "woni"};

        assertThat(utils.splitByDelimiter(input)).isEqualTo(expectString);
    }

    @Test
    public void split_구분자가_없을_때_문자열_그대로를_반환() {
        String input = "pobi";
        String[] expectString = {"pobi"};

        assertThat(utils.splitByDelimiter(input)).isEqualTo(expectString);
    }

    @Test
    public void 이동횟수가_숫자가_아닌_경우_예외_발생() {
        String input = "1.6";
        assertThatThrownBy(() -> utils.convertStringToInt(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 0 이상의 정수이어야 합니다.");
    }

    @Test
    public void 이동횟수가_음수인_경우_예외_발생() {
        int input = -1;
        assertThatThrownBy(() -> utils.isPositiveNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 음수가 될 수 없습니다.");
    }
}
