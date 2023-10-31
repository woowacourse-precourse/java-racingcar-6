package racingcar;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.util.vaildator.carNameValidator;

public class CarNameValidatorTest {

    @DisplayName("이름이 5자 이하인지 검증한다.")
    @ParameterizedTest
    @ValueSource(strings = {"pooobi", "asdfasdfa"})
    void validateInputNameSize(String carName) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> carNameValidator.validateInputNameSize(carName));
    }
}
