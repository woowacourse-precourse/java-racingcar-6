package racingcar.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ValidatorCarNamesInputTest {

    private Validator validator;

    @BeforeEach
    void beforeEach() {
        validator = new Validator();
        validator.setMaxCar(10); //최대 자동차 수 제한 설정
        validator.setAllowCarNameDuplication(false); //자동차 이름 중복 가능 여부 설정
    }

    @ParameterizedTest
    @MethodSource("provideCorrectInput")
    @DisplayName("자동차 이름 입력 검증")
    void 자동차_이름_입력_검증(String input) {
        run(input);
    }

    @ParameterizedTest
    @MethodSource("provideExceptionInput")
    @DisplayName("자동차 이름 입력 검증 예외")
    void 자동차_이름_입력_검증_예외(String input) {
        assertThatThrownBy(() -> run(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> provideCorrectInput() {
        return IntStream.rangeClosed(1, 10)
                .mapToObj(input -> String.join(
                        ",",
                        IntStream.rangeClosed(1, input)
                                .mapToObj(i -> "DY" + i)
                                .toList()
                ))
                .map(Arguments::of);
    }

    static Stream<Arguments> provideExceptionInput() {
        return Stream.of(
                Arguments.of("\n"),
                Arguments.of(",DY,"),
                Arguments.of("DYDYDYDYDY1,DY2,DY3"),
                Arguments.of("DY1,DY1,DY2"),
                Arguments.of("두,DY1,DY2"),
                Arguments.of("DY!@,DY1,DY2"),
                Arguments.of("D1,D2,D3,D4,D5,D6,D7,D8,D9,D10,D11")
        );
    }

    private void run(String input) {
        validator.validateInputCarName(input);
    }
}