package racingcar;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Name;

public class NameTest {

    @ParameterizedTest
    @ValueSource(strings = {"abcdef", "123456", "일이삼사오육"})
    void 다섯글자_이상_예외발생(String name) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> new Name(name)
        );
        assertThat(e.getMessage()).isEqualTo("이름은 최소 한글자 이상, 다섯글자 이하여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"abcde", "12345", "일이삼사오"})
    void 다섯글자_이하_정상(String name) {
        assertThatCode(
                () -> new Name(name))
                .doesNotThrowAnyException();
    }
}