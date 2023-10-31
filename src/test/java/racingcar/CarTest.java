package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;
import racingcar.domain.Name;

@DisplayName("Car 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class CarTest {

    private static final int MOVING_FORWARD = 4;
    private static Car car;

    @BeforeEach
    void setUp() {
        car = new Car(new Name("이하늘"));
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6})
    void move_메소드는_4보다_같거나_큰값이_주어지면_Position을_증가시킨다(int number) {
        car.move(number);
        Assertions.assertEquals(car.getPosition(), 1);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void move_메소드는_4보다_작은값이_주어지면_아무런_동작도_하지않는다(int number) {
        car.move(number);

        Assertions.assertEquals(car.getPosition(), 0);
    }

    @Test
    void isWinner_메소드는_Position이_같은_car가_주어지면_true를_반환한다() {
        Car winnerCar = new Car(new Name("늘하이"));

        car.move(MOVING_FORWARD);
        winnerCar.move(MOVING_FORWARD);

        Assertions.assertEquals(car.isWinner(winnerCar), true);
    }

    @Test
    void isWinner_메소드는_Position이_다른_car가_주어지면_false를_반환한다() {
        Car winnerCar = new Car(new Name("늘하이"));

        car.move(MOVING_FORWARD);
        winnerCar.move(MOVING_FORWARD);
        winnerCar.move(MOVING_FORWARD);

        Assertions.assertEquals(car.isWinner(winnerCar), false);
    }
}
