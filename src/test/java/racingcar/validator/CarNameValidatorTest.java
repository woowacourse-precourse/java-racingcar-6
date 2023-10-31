package racingcar.validator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

class CarNameValidatorTest {
    CarNameValidator carNameValidator = new CarNameValidator();

    @ParameterizedTest(name = "{index}:{1}")
    @MethodSource("invalidParameter")
    @DisplayName("자동차 이름 유효성 검사")
    void 자동차_이름_유효성_검사(String trialName) {
        Assertions.assertThatThrownBy(() -> carNameValidator.validateInputCarName(trialName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> invalidParameter() {
        return Stream.of(
                Arguments.of("car!","특수 문자"),
                Arguments.of("woo car","공백"),
                Arguments.of("jaemincar", "5글자 초과"),
                Arguments.of("car,car","중복")
        );
    }
}
