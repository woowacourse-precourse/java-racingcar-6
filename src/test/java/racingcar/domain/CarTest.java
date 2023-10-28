package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CarTest {

    @Test
    void Car_다섯자_초과_이름으로_생성() {
        String name = "123456789";
        Assertions.assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void Car_다섯자_이하_이름으로_생성() {
        String name = "12345";
        assertDoesNotThrow(() -> new Car(name));
    }

    @Test
    void move_이동이_이루어졌는지_확인() {

        Car car = new Car("foo");
        CarDistanceMessage before = car.getCarDistanceMessage();

        car.move();
        CarDistanceMessage after = car.getCarDistanceMessage();
        CarDistanceMessage expect = new CarDistanceMessage("foo", 1);

        assertAll(
                () -> assertNotEquals(before.toString(), after.toString()),
                () -> assertEquals(after.toString(), expect.toString())
        );

    }

    @Test
    void getCarDistanceMessage_메시지를_잘_생성하는지_확인() {

        Car car = new Car("foo");
        CarDistanceMessage message = car.getCarDistanceMessage();
        CarDistanceMessage expect = new CarDistanceMessage("foo", 0);

        assertEquals(message.toString(), expect.toString());

    }

}
