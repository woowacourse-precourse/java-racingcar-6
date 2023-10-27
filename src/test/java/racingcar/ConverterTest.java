package racingcar;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ConverterTest {

    @ParameterizedTest
    @MethodSource("splitByDelimiterArguments")
    void splitByDelimiterTest(String src, String delimiter, List<String> expected) {
        assertThat(Converter.splitByDelimiter(src, delimiter)).isEqualTo(expected);
    }

    static Stream<Arguments> splitByDelimiterArguments() {
        return Stream.of(
                Arguments.of("a,b,c", ",", List.of("a", "b", "c")),
                Arguments.of("a b c", " ", List.of("a", "b", "c")),
                Arguments.of(",,,", ",", List.of())
        );
    }
}