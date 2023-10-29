package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.MoveCarType;

public class CarTest {

    private final String carName = "yong";

    @Test
    @DisplayName("차 생성 되는지 테스트")
    public void testMakeValidCar() {
        Car car = makeValidCar();

        Assertions.assertEquals(carName, car.getName());
        Assertions.assertEquals(0, car.getPosition());
    }


    @Test
    @DisplayName("잘못된 이름(5글자 넘는)으로 차 생성 테스트")
    public void testMakeInvalidNameCar() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Car("123456"));
    }

    @Test
    @DisplayName("전진 테스트")
    public void testMoveForward() {
        Car car = makeValidCar();
        car.move(MoveCarType.FORWARD);

        Assertions.assertEquals(1, car.getPosition());
    }

    @Test
    @DisplayName("정지 테스트")
    public void testStop() {
        Car car = makeValidCar();
        car.move(MoveCarType.STOP);

        Assertions.assertEquals(0, car.getPosition());

    }

    private Car makeValidCar () {
        return new Car(carName);
    }

}
