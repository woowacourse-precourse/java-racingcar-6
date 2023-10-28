package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.utils.NumberGenerator;

class CarTest {

    private Car car;

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 랜덤숫자가_4이상일떄_자동차_전진(int randomNumber) {
        int expectedMoveNum = 1;
        NumberGenerator testNumberGenerator = new TestNumberGenerator(randomNumber);
        car = new Car("TestCar", testNumberGenerator);
        car.move();
        assertThat(car.getMoveNum()).isEqualTo(expectedMoveNum);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void 랜덤숫자가_4미만일때_자동차_멈춤(int randomNumber) {
        int expectedMoveNum = 0;
        NumberGenerator testNumberGenerator = new TestNumberGenerator(randomNumber);
        car = new Car("TestCar", testNumberGenerator);
        car.move();
        assertThat(car.getMoveNum()).isEqualTo(expectedMoveNum);
    }
}
