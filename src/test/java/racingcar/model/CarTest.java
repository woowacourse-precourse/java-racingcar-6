package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void getName() {
        //given
        String name = "pobi";
        Car car = new Car(name);
        //when
        String actual = car.getName();
        //then
        assertEquals(name, actual);

    }

    @Test
    void getPosition() {
        //given
        String name = "pobi";
        Car car = new Car(name);
        //when
        int actual = car.getPosition();
        //then
        assertEquals(0, actual);
    }

    @Test
    void setPosition() {
        //given
        String name = "pobi";
        Car car = new Car(name);
        //when
        car.setPosition(1);
        int actual = car.getPosition();
        //then
        assertEquals(1, actual);

    }
}