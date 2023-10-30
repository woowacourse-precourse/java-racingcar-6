package racingcar.model.cycle;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("[Race Count]")
class RaceCountTest {

    @ParameterizedTest
    @MethodSource
    @DisplayName("RaceCount 생성 테스트")
    public void raceCountConstructorSuccess(final String count) {
        Assertions.assertDoesNotThrow(
                () -> new RaceCount(count)
        );
    }

    static Stream<Arguments> raceCountConstructorSuccess() {
        return Stream.of(
                arguments("1"),
                arguments("200"),
                arguments("2147483647")
        );
    }


    @ParameterizedTest
    @MethodSource
    @DisplayName("RaceCount 생성 실패")
    public void raceCountConstructorFailure(final String count) {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new RaceCount(count)
        );
    }

    static Stream<Arguments> raceCountConstructorFailure() {
        return Stream.of(
                arguments("-1"),
                arguments("200o"),
                arguments("2.0"),
                arguments("2147483648")
        );
    }
}