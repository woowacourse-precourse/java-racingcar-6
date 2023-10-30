package racingcar.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ValidatorExecutionCountInputTest {

    private Validator validator;

    @BeforeEach
    void beforeEach() {
        validator = new Validator();
        validator.setMaxExecutionCount(100);
    }

    @ParameterizedTest
    @MethodSource("provideCorrectInput")
    @DisplayName("실행 횟수 입력 검증")
    void 실행_횟수_입력_검증(String input) {
        run(input);
    }

    @ParameterizedTest
    @MethodSource("provideExceptionInput")
    @DisplayName("실행 횟수 입력 검증 예외")
    void 실행_횟수_입력_검증_예외(String input) {
        assertThatThrownBy(() -> run(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> provideCorrectInput() {
        return IntStream.rangeClosed(1, 100)
                .mapToObj(input -> Arguments.of(String.valueOf(input)));
    }

    static Stream<Arguments> provideExceptionInput() {
        return Stream.of(
                Arguments.of("\n"),
                Arguments.of("ab"),
                Arguments.of("0"),
                Arguments.of("101")
        );
    }

    private void run(String input) {
        validator.validateInputCount(input);
    }
}