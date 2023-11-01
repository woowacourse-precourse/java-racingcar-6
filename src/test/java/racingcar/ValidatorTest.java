package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.utils.Validator;

public class ValidatorTest {

    @ParameterizedTest
    @MethodSource("provideListForIsDuplicateNameExistFail")
    void 중복이름_검증_예외발생(List<String> carNames) {
        assertThatThrownBy(
                () -> Validator.validateDuplicateCarName(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 이름은 중복될 수 없습니다.");
    }

    @ParameterizedTest
    @MethodSource("provideListForIsDuplicateNameExistPass")
    void 중복이름_검증_정상(List<String> carNames) {
        assertThatCode(
                () -> Validator.validateDuplicateCarName(carNames))
                .doesNotThrowAnyException();
    }

    private static Stream<Arguments> provideListForIsDuplicateNameExistFail() {
        return Stream.of(
                Arguments.of(List.of("AB", "AB")),
                Arguments.of(List.of("픽업트럭", "픽업트럭")),
                Arguments.of(List.of("1234", "1234"))
        );
    }

    private static Stream<Arguments> provideListForIsDuplicateNameExistPass() {
        return Stream.of(
                Arguments.of(List.of("AB", "XY")),
                Arguments.of(List.of("픽업트럭", "소나타")),
                Arguments.of(List.of("1234", "6789"))
        );
    }
}