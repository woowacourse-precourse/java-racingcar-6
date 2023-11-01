package racingcar.car;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CarTest {

    @Test
    void 자동차를_생성한다() {
        // given
        Car carA = new Car(new CarName("carA"), new Position(0));

        // then
        Assertions.assertThat(carA).isEqualTo(new Car(new CarName("carA"), new Position(0)));
    }

    @ParameterizedTest
    @MethodSource("전진_또는_중지할_수_있다_파라미터")
    void 전진_또는_중지할_수_있다(MoveNumber moveNumber, Position expected) {
        // given
        Position position = new Position(0);
        Car carA = new Car(new CarName("carA"), position);

        // when
        carA.move(moveNumber);

        // then
        Assertions.assertThat(position).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("전진_결과를_알_수_있다_파라미터")
    void 전진_결과를_알_수_있다(CarName carName, Position position, MoveNumber moveNumber, String expected) {
        // given
        Car carA = new Car(carName, position);

        // when
        String moveResult = carA.move(moveNumber);

        // then
        Assertions.assertThat(moveResult).isEqualTo(expected);
    }

    public static Stream<Arguments> 전진_또는_중지할_수_있다_파라미터() {
        return Stream.of(
                Arguments.of(new MoveNumber(3), new Position(0)),
                Arguments.of(new MoveNumber(4), new Position(1))
        );
    }

    public static Stream<Arguments> 전진_결과를_알_수_있다_파라미터() {
        return Stream.of(
                Arguments.of(new CarName("carA"), new Position(0), new MoveNumber(3), "carA : "),
                Arguments.of(new CarName("carA"), new Position(0), new MoveNumber(4), "carA : -")
        );
    }
}
