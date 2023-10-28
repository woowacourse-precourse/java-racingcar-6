package racingcar.utils.validator;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@Nested
@DisplayName("[Car Validator]")
class CarValidatorTest {

    @ParameterizedTest
    @MethodSource("validCarNames")
    @DisplayName("자동차 이름 검증 성공")
    public void isSuccessCarNameValidation(final String name) {
        Assertions.assertDoesNotThrow(
                () -> new CarValidator().validate(name) );

    }
    static Stream<Arguments> validCarNames() {
        return Stream.of(
                arguments("asbc"),
                arguments("자동차12"),
                arguments("자동차2"),
                arguments("자동2"),
                arguments("자2"),
                arguments("자"),
                arguments("car2")
        );
    }

    @ParameterizedTest
    @MethodSource("invalidCarNames")
    @DisplayName("자동차 이름 검증 실패(예외)")
    public void isExceptionCarNameValidation(final String name) {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new CarValidator().validate(name) );
    }

    static Stream<Arguments> invalidCarNames() {
        return Stream.of(
                arguments(""),
                arguments(" "),
                arguments("자동차222"),
                arguments((Object) null)
        );
    }


}