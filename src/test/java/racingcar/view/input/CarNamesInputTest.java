package racingcar.view.input;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CarNamesInputTest {
    @ParameterizedTest
    @MethodSource("parseArgumentsProvider")
    void 입력받은_문자열을_쉼표를_기준으로_파싱하여_객체를_생성한다(String rawString, List<String> expectedCarNames) {
        CarNamesInput carNamesInput = CarNamesInput.parse(rawString);

        assertThat(carNamesInput.carNames()).containsExactlyInAnyOrderElementsOf(expectedCarNames);
    }

    static Stream<Arguments> parseArgumentsProvider() {
        return Stream.of(
                Arguments.of("apple,melon,lime", List.of("apple", "melon", "lime")),
                Arguments.of("a,b", List.of("a", "b")),
                Arguments.of(",melon", List.of("", "melon")),
                Arguments.of(",", List.of("", ""))
        );
    }
}
