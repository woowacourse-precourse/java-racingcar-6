package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ConverterTest {

    @ParameterizedTest
    @MethodSource("splitByDelimiterArguments")
    void splitByDelimiter(String src, String delimiter, List<String> expected) {
        Assertions.assertThat(Converter.splitByDelimiter(src, delimiter)).isEqualTo(expected);
    }
    public static Stream<Arguments> splitByDelimiterArguments() {
        return Stream.of(
                Arguments.of("a,b,c,d" , "," , List.of("a","b","c","d")),
                Arguments.of("a,b,c,d," , "," , List.of("a","b","c","d")),
                Arguments.of("a b c d" , " " , List.of("a","b","c","d")),
                Arguments.of(",,," , "," , List.of())
        );
    }
}