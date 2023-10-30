package racingcar.model;

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
        String resultName = name.getName();

        // then
        Assertions.assertThat(resultName).isEqualTo(name);
    }
}
