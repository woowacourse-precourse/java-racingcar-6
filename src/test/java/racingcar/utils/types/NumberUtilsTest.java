package racingcar.utils.types;

import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("[Number Utils]")
class NumberUtilsTest {

    @ParameterizedTest
    @MethodSource
    @DisplayName("숫자가 범위 내에 있는지 확인 - Integer")
    public void isInRangeInteger(final int target, final int start, final int end) {
        Assertions.assertTrue(NumberUtils.isInRange(target, start, end));
    }

    static Stream<Arguments> isInRangeInteger() {
        return Stream.of(
                arguments(10, -1, 20),
                arguments(-1, -1, 20),
                arguments(20, -1, 20)
        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("숫자가 범위 내에 없는지 확인 - Integer")
    public void isNotInRangeInteger(final int target, final int start, final int end) {
        Assertions.assertFalse(NumberUtils.isInRange(target, start, end));
    }

    static Stream<Arguments> isNotInRangeInteger() {
        return Stream.of(
                arguments(-2, -1, 20),
                arguments(-1, 19, 20),
                arguments(53, -1, 20)
        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("숫자가 범위 내에 있는지 확인 - Long")
    public void isInRangeLong(final long target, final long start, final long end) {
        Assertions.assertTrue(NumberUtils.isInRange(target, start, end));
    }

    static Stream<Arguments> isInRangeLong() {
        return Stream.of(
                arguments(10L, -1L, 20L),
                arguments(-1L, -1L, 20L),
                arguments(20L, -1L, 20L)
        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("숫자가 범위 내에 없는지 확인 - Long")
    public void isNotInRangeNumber(final long target, final long start, final long end) {
        Assertions.assertFalse(NumberUtils.isInRange(target, start, end));
    }

    static Stream<Arguments> isNotInRangeNumber() {
        return Stream.of(
                arguments(-2L, -1L, 20L),
                arguments(-1L, 19L, 20L),
                arguments(53L, -1L, 20L)
        );
    }


    @ParameterizedTest
    @MethodSource
    @DisplayName("숫자가 범위 내에 있는지 확인 - Double")
    public void isInRangeDouble(final double target, final double start, final double end) {
        Assertions.assertTrue(NumberUtils.isInRange(target, start, end));
    }

    static Stream<Arguments> isInRangeDouble() {
        return Stream.of(
                arguments(10.0, -1.0, 20.0),
                arguments(-1.0, -1.0, 20.0),
                arguments(20.0, -1.0, 20.0)
        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("숫자가 범위 내에 없는지 확인 - Double")
    public void isNotInRangeDouble(final double target, final double start, final double end) {
        Assertions.assertFalse(NumberUtils.isInRange(target, start, end));
    }

    static Stream<Arguments> isNotInRangeDouble() {
        return Stream.of(
                arguments(-2.0, -1.0, 20.0),
                arguments(-1.0, 19.0, 20.0),
                arguments(53.0, -1.0, 20.0)
        );
    }
}