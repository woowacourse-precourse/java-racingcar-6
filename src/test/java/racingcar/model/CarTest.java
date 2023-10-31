package racingcar.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
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
    void Car_객체_생성_성공() {
        assertEquals(car1.getName(), "poby");
        assertEquals(car1.getDistance(), 0);
    }

    @Test
    void move_자동차를_한칸_움직인다() {
        car1.move();
        assertEquals(car1.getDistance(), 1);

        car1.move();
        assertEquals(car1.getDistance(), 2);
    }

    @Test
    void equals_동등성_비교() {
        assertFalse(car1 == car2);
        assertTrue(car1.equals(car2));
    }

    @Test
    void hashcode_해시코드_비교() {
        assertTrue(car1.hashCode() == car2.hashCode());
    }
}