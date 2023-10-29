package racingcar.utils.validator;

import static org.junit.jupiter.params.provider.Arguments.*;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("[Car Common Validator]")
class CarCommonValidatorTest {

    @Test
    @DisplayName("비어있는 값을 입력하지 않았는지 확인 - 빈 값이 아닐 떄")
    public void enterNotEmptyCarName() {
        Assertions.assertDoesNotThrow(() -> new CarCommonValidator().validate("acb,dffs,dfdf"));
    }

    @ParameterizedTest
    @MethodSource("emtpytCarNames")
    @DisplayName("비어있는 값을 입력하지 않았는지 확인 - 빈 값 입력할 때")
    public void enterEmptyCarName() {
        Assertions.assertDoesNotThrow(() -> new CarCommonValidator().validate("acb,dffs,dfdf"));
    }

    static Stream<Arguments> emtpytCarNames() {
        return Stream.of(
                arguments(""),
                arguments("   "),
                arguments((Object) null)
        );
    }


}