package validate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.validate.RoundNumberValidation;
import racingcar.validate.UserInputValidation;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RoundNumberValidationTest {
    private UserInputValidation<String> userInputValidation;

    @BeforeEach
    public void setUp() {
        userInputValidation = new RoundNumberValidation();
    }

    @DisplayName("1이상의 숫자가 들어올 때 true를 반환한다")
    @ParameterizedTest
    @ValueSource(strings = {"1", "10", "100", "1000"})
    public void roundNumberValidationTest(final String data) {
        // when
        boolean result = userInputValidation.validate(data);
        // then
        assertThat(result).isTrue();
    }

    @DisplayName("숫자가 아닌 값이 들어올 때 false를 반환한다")
    @ParameterizedTest
    @ValueSource(strings = {"a", "b", "나", "%5"})
    public void roundNumberValidationTest2(final String data) {
        // when
        boolean result = userInputValidation.validate(data);
        // then
        assertThat(result).isFalse();
    }

    @DisplayName("0 이하 값이 들어올 때 false를 반환한다")
    @ParameterizedTest
    @ValueSource(strings = {"0", "- 1", " - 22", " - 33"})
    public void roundNumberValidationTest3(final String data) {
        // when
        boolean result = userInputValidation.validate(data);
        // then
        assertThat(result).isFalse();
    }
}
