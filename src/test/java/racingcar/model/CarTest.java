package racingcar.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
    Car car1;
    Car car2;

    @BeforeEach
    void setup() {
        String poby = "poby";
        int distance = 0;

        car1 = new Car(poby, distance);

        car2 = new Car(poby, distance);
    }

    @Test
    @DisplayName("Car 객체 생성에 성공한다.")
    void CarTest() {
        assertEquals(car1.getName(), "poby");
        assertEquals(car1.getDistance(), 0);
    }

    @Test
    @DisplayName("움직임에 성공한다.")
    void moveTest() {
        car1.move();
        assertEquals(car1.getDistance(), 1);

        car1.move();
        assertEquals(car1.getDistance(), 2);
    }

    @Test
    @DisplayName("동등성 비교에 성공한다.")
    void equalsTest() {
        assertFalse(car1 == car2);
        assertTrue(car1.equals(car2));
    }

    @Test
    @DisplayName("해시코드 비교에 성공한다.")
    void hashcodeTest() {
        assertTrue(car1.hashCode() == car2.hashCode());
    }
}