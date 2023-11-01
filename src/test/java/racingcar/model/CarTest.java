package racingcar.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void Car_객체_생성_테스트() {
        try {
            Car car = new Car(new Name("픽업 트럭"));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    void Car_객체_생성_실패() {
        assertThrows(IllegalArgumentException.class, () -> {
            Car car = new Car(null);
        });
    }
}