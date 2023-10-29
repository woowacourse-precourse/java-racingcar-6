package utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import model.Car;
import model.Cars;
import org.junit.jupiter.api.Test;

public class UtilsTest {
    Utils utils = new Utils();

    @Test
    public void 입력값에_공백이_포함된_경우_예외_발생() {
        String input = " pobi";
        assertThatThrownBy(() -> utils.hasSpace(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력은 공백이 포함될 수 없습니다.");
    }

    @Test
    public void 입력값이_공백인_경우_예외_발생() {
        String input="";
        assertThatThrownBy(() -> utils.isEmpty(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력은 공백일 수 없습니다.");
    }

    @Test
    public void 입력값이_5자를_초과하는_경우_예외_발생() {
        String input = "#4abc3";
        assertThatThrownBy(() -> utils.isOverLength(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력은 5자 이하여야 합니다.");
    }

    @Test
    public void 중복되는_이름을_가진_자동차가_있는_경우_예외_발생() {
        String input = "pobi,pobi";
        assertThatThrownBy(() -> utils.duplicateCarName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 이름은 중복되지 않은 고유한 값이어야 합니다.");
    }

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
}
