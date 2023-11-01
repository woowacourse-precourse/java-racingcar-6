package racingcarv2;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcarv2.model.Car;
import racingcarv2.model.Name;
import racingcarv2.model.Position;

public class CarTest {
    private Car car = new Car(new Name("pobi"), new Position(1));

    @Test
    void Car_생성_검증() {
        Assertions.assertThat(car.getName().getNameValue()).isEqualTo("pobi");
        Assertions.assertThat(car.getPosition()).isEqualTo(new Position(1));
    }

    private static Stream<Arguments> generateHigherThanFour() {
        return Stream.of(
                Arguments.of(4),
                Arguments.of(5),
                Arguments.of(6)
        );
    }

    @ParameterizedTest
    @MethodSource("generateHigherThanFour")
    void 인자가_4이상이면_전진한다(int higherThanFour) {
        car.move(higherThanFour);

        Assertions.assertThat(car.getPosition()).isEqualTo(new Position(2));
    }


    private static Stream<Arguments> generateLowerThanFour() {
        return Stream.of(
                Arguments.of(3),
                Arguments.of(2),
                Arguments.of(1)
        );
    }

    @ParameterizedTest
    @MethodSource("generateLowerThanFour")
    void 인자가_4보다_작으면_멈춘다(int lowerThanFour) {
        car.move(lowerThanFour);

        Assertions.assertThat(car.getPosition()).isEqualTo(new Position(1));
    }

    @Test
    void 같은_Position_검증() {
        org.junit.jupiter.api.Assertions.assertTrue(car.isSamePosition(new Car(
                new Name("xxx"), new Position(1))));
        org.junit.jupiter.api.Assertions.assertFalse(car.isSamePosition(new Car(
                new Name("xxx"), new Position(2))));
    }

}
