package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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
        CarDistanceMessage before = car.createCarDistanceMessage();

        car.move();
        CarDistanceMessage after = car.createCarDistanceMessage();

        assertAll(
                () -> assertNotEquals(before.toString(), after.toString()),
                () -> Assertions.assertThat(after.toString()).contains("-")
        );

    }

    @Test
    void getCarDistanceMessage_메시지를_잘_생성하는지_확인() {

        Car car = new Car("foo");

        CarDistanceMessage message = car.createCarDistanceMessage();
        CarDistanceMessage expect = new CarDistanceMessage("foo", 0);

        assertEquals(message.toString(), expect.toString());

    }

    @Test
    void getWinnersMessage_우승자를_잘_추리는지_확인() {

        List<Car> cars = new ArrayList<>();
        cars.add(new Car("foo"));
        cars.add(new Car("bar"));

        cars.get(1).move();
        WinnersMessage message = Car.createWinnersMessage(cars);
        WinnersMessage expect = new WinnersMessage(List.of("bar"));

        assertEquals(message.toString(), expect.toString());

    }

    @Test
    void getWinnersMessage_우승자_여러_명을_잘_추리는지_확인() {

        List<Car> cars = new ArrayList<>();
        cars.add(new Car("foo"));
        cars.add(new Car("bar"));
        cars.add(new Car("baz"));

        cars.get(0).move();
        cars.get(1).move();
        WinnersMessage message = Car.createWinnersMessage(cars);
        WinnersMessage expect = new WinnersMessage(List.of("foo", "bar"));

        assertEquals(message.toString(), expect.toString());

    }

}
