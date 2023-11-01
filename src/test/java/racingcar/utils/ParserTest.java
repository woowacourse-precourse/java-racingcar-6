package racingcar.utils;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ParserTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    void parseInteger_메서드는_String_을_Integer_로_변환한다(String input) {
        Integer output = Parser.parseInteger(input);
        assertThat(output).isInstanceOf(Integer.class);
    }

    @ParameterizedTest
    @MethodSource("provideListInformation")
    void parseStrings_메서드는_String_을_List_로_변환한다(String input, int result) {
        List<String> output = Parser.parseStrings(input);
        assertThat(output.size()).isEqualTo(result);
    }

    static List<Arguments> provideListInformation() {
        return Arrays.asList(
                Arguments.of("1, 2", 2),
                Arguments.of("1, 2, 3", 3),
                Arguments.of("1", 1),
                Arguments.of("1,2,3", 3),
                Arguments.of("1,2, 3", 3)
        );
    }
}
