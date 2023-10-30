package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.random_generator.FalseRandomMove;
import racingcar.domain.car.random_generator.TrueRandomMove;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    Car car;

    @DisplayName("moveCar() 실행 시 randomUtil.moveForward()가 true이면 moveCount를 1 증가")
    @Test
    void carMoveTestIfMoveForwardIsTrue() {
        int expected = 1;

        car = new Car("test",new TrueRandomMove());
        car.moveCar();
        int carMove = car.getMoveCount();

        assertThat(carMove)
                .isEqualTo(expected);
    }

    @DisplayName("moveCar() 실행 시 randomUtil.moveForward()가 false면 moveCount를 0 증가")
    @Test
    void carMoveTestIfMoveForwardIsFalse() {
        int expected = 0;

        car = new Car("test",new FalseRandomMove());
        car.moveCar();
        int carMove = car.getMoveCount();

        assertThat(carMove)
                .isEqualTo(expected);
    }

}
