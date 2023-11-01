package racingcar.util.style;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.exception.ExceptionMessages;
import racingcar.exception.RacingCarException;

public class DistanceStyleFactoryTest {
    private static Stream<Arguments> provideDistanceStylesAndCreatedClass() {
        return Stream.of(
                Arguments.of(DistanceStyles.DASH, DashDistanceStyle.class)
        );
    }

    @ParameterizedTest
    @MethodSource("provideDistanceStylesAndCreatedClass")
    void DistanceStyles_Enum_에따라_스타일_객체_생성(final DistanceStyles distanceStyles, final Class expected) {
        final DistanceStyle actual = DistanceStyleFactory.create(distanceStyles);
        assertThat(actual).isInstanceOf(expected);
    }

    @Test
    void DistanceStyles_Enum_이_null_일때_RacingCarException_예외_발생() {
        assertThatThrownBy(() -> DistanceStyleFactory.create(null))
                .isInstanceOf(RacingCarException.class)
                .hasMessageContaining(ExceptionMessages.DISTANCE_NOT_FOUND.getMessage());
    }

    @Test
    void DistanceStyles_Enum_을_구현하지_않은경우_RacingCarException_예외_발생() {
        assertThatThrownBy(() -> DistanceStyleFactory.create(DistanceStyles.UNKNOWN))
                .isInstanceOf(RacingCarException.class)
                .hasMessageContaining(ExceptionMessages.DISTANCE_NOT_FOUND.getMessage());
    }
}
