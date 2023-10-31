package racingcar;

import org.junit.jupiter.api.Test;
import util.Validate;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidateTest {
    Validate validate = new Validate();
    @Test
    void 자동차_이름들이_한줄로_입력받을_때_앞에_콤마가_있을_때_예외_발생(){
        assertThatThrownBy(() -> validate.inputLineOfCarNames(",abc,def"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력 형식이 맞지 않습니다.");
    }
    @Test
    void 자동차_이름들이_한줄로_입력받을_때_뒤에_콤마가_있을_때_예외_발생(){
        assertThatThrownBy(() -> validate.inputLineOfCarNames("abc,def,"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력 형식이 맞지 않습니다.");
    }
    @Test
    void 자동차_이름이_중복일_때_예외_발생(){
        List<String> input = Arrays.asList("abc","def","abc");
        assertThatThrownBy(() -> validate.CarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름이 중복됩니다.");
    }
    @Test
    void 자동차_이름이_정규표현에_맞지않을_때_예외_발생(){
        List<String> input = Arrays.asList("abc","def","@bc");
        assertThatThrownBy(() -> validate.CarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름 형식이 맞지 않습니다.");
    }
    @Test
    void 자동차_이름의_길이가_최대를_넘어갔을_때_예외_발생(){
        List<String> input = Arrays.asList("abc","def","abcdef");
        assertThatThrownBy(() -> validate.CarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름 길이가 초과했습니다.");
    }
    @Test
    void 시도할_회수를_입력할_때_숫자_형식이_아닐_때_예외_발생(){
        String input = "1*";
        assertThatThrownBy(() -> validate.numberOfAttemptsForm(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자 형식이 아닙니다.");
    }
    @Test
    void 시도할_회수가_0이_입력_됐을_때_예외_발생(){
        String input = "0";
        assertThatThrownBy(() -> validate.numberOfAttemptsForm(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("0은 입력할 수 없습니다.");
    }
}
