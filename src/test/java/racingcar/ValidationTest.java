package racingcar;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static racingcar.Validation.*;

class ValidationTest {
    @Test
    void validateCarNames_메서드로_구분자가_있는_경우_주어진_값을_문자열_리스트로_반환() {
        String input = "1,2";
        List<String> result = validateCarNames(input);

        assertThat(result).contains("2", "1");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void validateCarNames_메서드로_구분자가_없는_경우_주어진_값을_문자열_리스트로_반환() {
        String input = "1";
        List<String> result = validateCarNames(input);

        assertThat(result).contains("1");
    }

    @Test
    void validateCarNames_메서드_사용시_5자_이상의_이름_입력시_예외_발생(){
        String input = "ABCDEF";

        assertThatThrownBy(() -> validateCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1자 이상, 5자 이하로 자동차 이름을 지정해주세요.");
    }

    @Test
    void validateCarNames_메서드_사용시_1자_이하의_이름_입력시_예외_발생(){
        String input = "";

        assertThatThrownBy(() -> validateCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1자 이상, 5자 이하로 자동차 이름을 지정해주세요.");
    }

    @Test
    void validateMoveNumber_메서드_사용시_문자가_들어갔을_때_예외_발생(){
        String input = "a";

        assertThatThrownBy(() -> validateMoveNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자를 입력하세요.");
    }

    @Test
    void validateMoveNumber_메서드_사용시_숫자가_들어갔을_때_숫자_반환(){
        String input = "5";
        int result = validateMoveNumber(input);

        assertThat(result).isEqualTo(5);
    }

}