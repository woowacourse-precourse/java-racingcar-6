package racingcar.util;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"asdf", "aaa", "pobi", "Mr Jo"})
    @DisplayName("유효한 자동차 이름")
    void validateCarName_유효한_자동차_이름(String input) {
        Validator.validateCarName(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"  ", " aa a", "abc ", "pobipobi"})
    @DisplayName("유효하지 않은 자동차 이름")
    void validateCarName_유효하지_않은_자동차_이름(String input) {
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateCarName(input);
        });
    }

    @ParameterizedTest
    @MethodSource("data_중복_없는_이름_배열")
    @DisplayName("이름 배열에 중복 없는 경우")
    void validateCarNames_중복_없는_이름_배열(List<String> input) {
        Validator.validateCarNames(input);
    }

    static Stream<Arguments> data_중복_없는_이름_배열() {
        return Stream.of(
                Arguments.of(Arrays.asList("a", "b", "c")),
                Arguments.of(Arrays.asList("pobi", "woni", "jun"))
        );
    }

    @ParameterizedTest
    @MethodSource("data_중복_있는_이름_배열")
    @DisplayName("이름 배열에 중복 있는 경우 예외 발생")
    void validateCarNames_중복_있는_이름_배열(List<String> input) {
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateCarNames(input);
        });
    }

    static Stream<Arguments> data_중복_있는_이름_배열() {
        return Stream.of(
                Arguments.of(Arrays.asList("a", "a", "c")),
                Arguments.of(Arrays.asList("pobi", "woni", "woni"))
        );
    }

}
