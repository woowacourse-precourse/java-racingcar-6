package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {

    @ParameterizedTest(name = "입력값 : {0}")
    @ValueSource(strings = {"k", "poobi"})
    @DisplayName("자동차 이름 생성 성공")
    void givenInput_whenCreateName_thenNoException(String input) {
        // when
        Name name = new Name(input);

        // then
        assertThat(name.getName()).isEqualTo(input);
    }

    @ParameterizedTest(name = "입력값 : {0}")
    @ValueSource(strings = {"", "  ", "abcabc", "p obi"})
    @DisplayName("자동차 이름 생성 실패 예외 처리")
    void givenInput_whenCreateName_thenThrowException(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Name(input));
    }

}
