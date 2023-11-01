package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

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

    @ParameterizedTest
    @MethodSource("data_0_이상의_정수")
    @DisplayName("0 이상의 정수")
    void parseRound_0_이상의_정수(String input, Integer expected) {
        Integer round = StringParser.parseRound(input);
        assertThat(round).isEqualTo(expected);
    }

    static Stream<Arguments> data_0_이상의_정수() {
        return Stream.of(
                Arguments.of("0", 0),
                Arguments.of("1", 1),
                Arguments.of("15", 15)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "-3", "-10"})
    @DisplayName("음의 정수인 경우 예외 발생")
    void parseRound_음의_정수(String input) {
        assertThrows(IllegalArgumentException.class, () -> {
            StringParser.parseRound(input);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"ㅁㄴㅁㄴㅇㄹ", "bsd", "   ", "123 ", "12  12"})
    @DisplayName("정수 포맷이 아닌 경우 예외 발생")
    void parseRound_정수_포맷_아님(String input) {
        assertThrows(IllegalArgumentException.class, () -> {
            StringParser.parseRound(input);
        });
    }
}