package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RoundTest {

    @ParameterizedTest
    @DisplayName("입력된 시도횟수(라운드수)가 유효하지 않으면 예외 발생")
    @ValueSource(strings = {"5a", "-1", "0"})
    void getRounds_exceptionTest(String input) {
        Rounds sample = new Rounds();
        assertThatIllegalArgumentException().isThrownBy(() -> sample.getRounds(input));
    }

    @ParameterizedTest
    @DisplayName("입력된 시도횟수가 유효하면 예외 발생 없이 정상 종료")
    @ValueSource(strings = {"5", "123"})
    void getRounds_normalTest(String input) {
        Rounds sample = new Rounds();
        assertThatCode(() -> sample.getRounds(input)).doesNotThrowAnyException();
    }
}
