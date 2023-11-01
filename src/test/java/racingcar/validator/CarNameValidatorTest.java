package racingcar.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNameValidatorTest {
    @Test
    @DisplayName("성공 - 요구사항에 맞는 이름 입력")
    void right_Name() {
        //given
        List<String> input = List.of("a", "b", "c");
        //when
        //then
        CarNameValidator.validateNameLength(input);
    }

    @Test
    @DisplayName("실패 - 이름 5자 초과")
    void name_Length_Over() {
        //given
        List<String> input = List.of("abcdef", "b", "c");
        //when
        //then
        assertThatThrownBy(() -> CarNameValidator.validateNameLength(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 이름은 5자 이하만 가능합니다.\n");
    }

    @Test
    @DisplayName("실패 - 중복된 이름 존재")
    void name_Duplicate() {
        //given
        List<String> input = List.of("a", "a", "c");
        //when
        //then
        assertThatThrownBy(() -> CarNameValidator.validateDuplicatedName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 중복된 이름입니다.\n");
    }

    @Test
    @DisplayName("실패 - 이름 공백 포함")
    void name_Empty() {
        //given
        List<String> input = List.of("a", " ", "c");
        //when
        //then
        assertThatThrownBy(() -> CarNameValidator.validateWhiteSpace(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 이름을 입력해주세요.\n");
    }
}