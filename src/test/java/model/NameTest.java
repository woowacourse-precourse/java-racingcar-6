package model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NameTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobi", "lisa", "jiny"})
    @DisplayName("정상 이름 입력 테스트")
    void 이름_정상_입력_테스트(String input) {
        //given
        String name = input;

        //when
        Name carsName = new Name(name);
        String resultName = carsName.getName();

        // then
        Assertions.assertThat(resultName).isEqualTo(name);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobipobi", "lisalisa", "jinyjiny"})
    @DisplayName("5글자 이상 이름 입력시 예외 발생 테스트")
    void 이름_입력_예외_테스트(String input) {
        //given
        String name = input;

        //when, then
        Assertions.assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("5글자 미만 이름만 입력 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @DisplayName("공백 입력시 예외 발생 테스트")
    void 이름_입력_예외_테스트_공백(String input) {
        //given
        String name = input;

        //when, then
        Assertions.assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공백 혹은 빈 문자열은 입력 할 수 없습니다.");
    }
}
