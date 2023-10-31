package racingcar.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

class ParserTest {
    @ParameterizedTest(name = "{0}")
    @MethodSource("Parameters")
    @DisplayName("파싱 검사 절대 예외 X")
    void checkParser(String testName, String carNames) {
        assertThatCode(() -> Parser.parseCarNames(carNames))
                .doesNotThrowAnyException();
    }

    private static Stream<Arguments> Parameters() {
        return Stream.of(
                Arguments.of("길이 0", "Hot,"),
                Arguments.of("공백", "Hot, "),
                Arguments.of("빈 값", ""),
                Arguments.of("중복된 자동차명", "Fried, Fried")
        );
    }
}