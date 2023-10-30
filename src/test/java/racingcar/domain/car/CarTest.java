package racingcar.domain.car;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.position.Position;
import racingcar.domain.power.Power;
import racingcar.domain.power.PowerGenerator;

@DisplayName("자동차 테스트")
class CarTest {

    @DisplayName("충분한 파워가 있으면 움직인다")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void testTryDriveWithEnoughPower(int power) {
        PowerGenerator powerGenerator = () -> new Power(power);
        Car car = new Car("test", 0, powerGenerator);

        car.tryDrive();
        assertEquals(new Position(1), car.getPosition());
    }

    @DisplayName("파워가 부족하면 움직이지 않는다")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void testTryDriveWithInsufficientPower(int power) {
        PowerGenerator powerGenerator = () -> new Power(power);
        Car car = new Car("test", 0, powerGenerator);

        car.tryDrive();
        assertEquals(new Position(0), car.getPosition());
    }
}