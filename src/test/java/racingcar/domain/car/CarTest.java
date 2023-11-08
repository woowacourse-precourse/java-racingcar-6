package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.constant.errorMessage.ErrorMessages;
import racingcar.constant.errorMessage.InvalidArgumentException;

class CarTest {

    private static final int INITIALIZED_POSITION_NUMBER = 0;
    private static final int INCREASING_COUNT_NUMBER = 1;

    @ParameterizedTest
    @ValueSource(strings = {"abcdef", "ghijkl", "mnopqrs"})
    @DisplayName("자동차 이름 입력 다섯 자 초과인 경우 예외 처리 테스트")
    void carNameIsTooLongErrorTest(final String name) {
        final String message = ErrorMessages.CAR_NAME_IS_TOO_LONG.getMessage();
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(InvalidArgumentException.class)
                .hasMessageContaining(message);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "\t", "\n"})
    @DisplayName("자동차 이름 입력 NULL 혹은 공백일 경우 예외 처리 테스트")
    void carNameIsNullOrBlankErrorTest(final String name) {
        final String message = ErrorMessages.CAR_NAME_IS_NULL_OR_BLANK.getMessage();
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(InvalidArgumentException.class)
                .hasMessageContaining(message);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi", "woni", "jun", "a b"})
    @DisplayName("자동차 객체 생성 테스트")
    void carObjectCreationTest(final String name) {
        final Car car = new Car(name);
        assertThat(car.getName()).isEqualTo(name);
        assertThat(car.getPosition()).isEqualTo(INITIALIZED_POSITION_NUMBER);
    }

    @ParameterizedTest
    @MethodSource("provideForSamePositionTest")
    @DisplayName("자동차 이동거리 동일한지 테스트")
    void isSamePositionTest(final String name, final int position) {
        final Car car = new Car(name);
        repeatMoveForward(car, position);
        assertThat(car.isSamePosition(position)).isTrue();
    }

    public static Stream<Arguments> provideForSamePositionTest() {
        return Stream.of(
                Arguments.of("weqwe", 3),
                Arguments.of("wew", 5),
                Arguments.of("qwe w", 5)
        );
    }

    private void repeatMoveForward(final Car car, final int position) {
        for (int i = 0; i < position; i++) {
            car.moveForward(() -> true);
        }
    }

    @ParameterizedTest
    @MethodSource("provideForMoveForwardTest")
    @DisplayName("검증 통과한 자동차 1씩 이동 테스트")
    void moveForwardTest(final String name) {
        final Car car = new Car(name);
        final int carPosition = car.getPosition();
        car.moveForward(() -> true);

        final int actual = car.getPosition();
        final int expected = carPosition + INCREASING_COUNT_NUMBER;
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("provideForMoveForwardTest")
    @DisplayName("검증 통과 못한 자동차 테스트")
    void goForwardFalseTest(final String name) {
        final Car car = new Car(name);
        final int expected = car.getPosition();
        car.moveForward(() -> false);

        final int actual = car.getPosition();
        assertThat(actual).isEqualTo(expected);
    }

    public static Stream<Arguments> provideForMoveForwardTest() {
        return Stream.of(
                Arguments.of("pobi"),
                Arguments.of("woni"),
                Arguments.of("jun"));
    }
}
