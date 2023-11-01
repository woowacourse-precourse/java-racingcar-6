package racingcar.utils.validator;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("[Race Count Validator]")
class RaceCountValidatorTest {


    @ParameterizedTest
    @MethodSource
    @DisplayName("레이싱 카운드 올바른 값 입력")
    public void validRacingCount(final String value) {
        Assertions.assertDoesNotThrow(
                () -> new RaceCountValidator().validate(value)
        );
    }

    static Stream<Arguments> validRacingCount() {
        return Stream.of(
                arguments("1"),
                arguments("2147483647")
        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("레이싱 카운드 옳바르지 않은 값 입력 - 문자 포함")
    public void invalidRacingCountContainsWord(final String value) {
        Assertions.assertThrows( IllegalArgumentException.class,
                () -> new RaceCountValidator().validate(value)
        );
    }

    static Stream<Arguments> invalidRacingCountContainsWord() {
        return Stream.of(
                arguments("1."),
                arguments("1,"),
                arguments("1)"),
                arguments("922337203685a807")
        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("레이싱 카운드 옳바르지 않은 값 입력 - 최대값 초과 최소값 미만")
    public void invalidRacingCountOverRange(final String value) {
        Assertions.assertThrows( IllegalArgumentException.class,
                () -> new RaceCountValidator().validate(value)
        );
    }

    static Stream<Arguments> invalidRacingCountOverRange() {
        return Stream.of(
                arguments("0"),
                arguments("9223372036854775808")
        );
    }
}