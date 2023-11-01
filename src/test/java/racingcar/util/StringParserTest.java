package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import net.bytebuddy.description.annotation.AnnotationList.Empty;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.view.ConsoleScanner;

class StringParserTest {

    @ParameterizedTest
    @MethodSource("data_구분자_기준_파싱")
    @DisplayName("구분자 기준으로 문자열 파싱")
    void parseCarName_구분자_기준_파싱(String input, List<String> expected) {
        List<String> parsed = StringParser.parseCarName(input);
        assertThat(parsed).isEqualTo(expected);
    }

    static Stream<Arguments> data_구분자_기준_파싱() {
        return Stream.of(
                Arguments.of("a,b,c", Arrays.asList("a", "b", "c")),
                Arguments.of("abc,bcd,cde", Arrays.asList("abc", "bcd", "cde")),
                Arguments.of("pobi,woni,jun", Arrays.asList("pobi", "woni", "jun"))
        );
    }

    @ParameterizedTest
    @MethodSource("data_구분자_없는_경우")
    @DisplayName("구분자가 없으면 문자열 그대로")
    void parseCarName_구분자가_없는_경우(String input, List<String> expected) {
        List<String> parsed = StringParser.parseCarName(input);
        assertThat(parsed).isEqualTo(expected);
    }

    static Stream<Arguments> data_구분자_없는_경우() {
        return Stream.of(
                Arguments.of("a", List.of("a")),
                Arguments.of("abcde", List.of("abcde")),
                Arguments.of("pobi", List.of("pobi"))
        );
    }


    @ParameterizedTest
    @ValueSource(strings = {",", ",,", ",,,"})
    @DisplayName("구분자만 있으면 예외 발생")
    void parseCarName_구분자만_있는_경우(String input) {
        assertThrows(IllegalArgumentException.class, () -> {
            StringParser.parseCarName(input);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {",a,b", ",ab,bc", ",,aa,bb"})
    @DisplayName("구분자로 시작하면 예외 발생")
    void parseCarName_구분자로_시작하는_경우(String input) {
        assertThrows(IllegalArgumentException.class, () -> {
            StringParser.parseCarName(input);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"a,b,", "ab,bc,", ",aa,bb,"})
    @DisplayName("구분자로 끝나면 예외 발생")
    void parseCarName_구분자로_끝나는_경우(String input) {
        assertThrows(IllegalArgumentException.class, () -> {
            StringParser.parseCarName(input);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    @DisplayName("공백인 경우 예외 발생")
    void parseCarName_공백인_경우(String input) {
        assertThrows(IllegalArgumentException.class, () -> {
            StringParser.parseCarName(input);
        });
    }
}