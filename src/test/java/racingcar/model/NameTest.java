package racingcar.model;

import model.Name;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NameTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobi", "lisa", "jiny"})
    public void 이름_정상_입력_테스트(String input) {
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
    public void 이름_입력_예외_테스트(String input) {
        //given
        String name = input;

        //when, then
        Assertions.assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("5글자 미만 이름만 입력 가능합니다.");
    }
}
