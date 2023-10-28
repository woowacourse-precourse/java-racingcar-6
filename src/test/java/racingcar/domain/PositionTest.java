package racingcar.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositionTest {

    @Test
    public void 포지션_기본_생성_테스트() {
        // given
        Position position = new Position();

        // when, then
        assertThat(position).isEqualTo(new Position(0));
    }
    
    @Test
    public void 포지션_생성자_생성_테스트() {
        // given
        Position position = new Position(7);

        // when, then
        assertThat(position).isEqualTo(new Position(7));
    }

    @Test
    public void 음수_포지션_예외발생_테스트() {
        assertThatThrownBy(() -> new Position(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 포지션_증가_테스트() {
        // given
        Position position = new Position(7);

        // when
        position.increase();

        // then
        assertThat(position).isEqualTo(new Position(8));
    }

    @Test
    public void 포지션_복사_테스트() {
        // given
        Position position = new Position(7);

        // when
        Position copyPosition = position.copy();

        // then
        assertThat(position).isEqualTo(copyPosition);
    }

    @ParameterizedTest
    @MethodSource("positionCompareInputProvider")
    public void 포지션_비교_테스트(int me, int other, int expected) {
        // given
        Position position1 = new Position(me);
        Position position2 = new Position(other);

        // when
        int result = position1.compareTo(position2);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("positionGreaterInputProvider")
    public void 포지션_더_큰지_확인하는_테스트(int me, int other, boolean expected) {
        // given
        Position position1 = new Position(me);
        Position position2 = new Position(other);

        // when
        boolean result = position1.isGreaterThen(position2);

        // then
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> positionCompareInputProvider() {
        return Stream.of(
                Arguments.of(3, 4, -1),
                Arguments.of(4, 3, 1),
                Arguments.of(3, 6, -3),
                Arguments.of(6, 3, 3),
                Arguments.of(3, 3, 0)
        );
    }

    private static Stream<Arguments> positionGreaterInputProvider() {
        return Stream.of(
                Arguments.of(3, 4, false),
                Arguments.of(4, 3, true),
                Arguments.of(3, 6, false),
                Arguments.of(6, 3, true),
                Arguments.of(3, 3, false)
        );
    }
}
