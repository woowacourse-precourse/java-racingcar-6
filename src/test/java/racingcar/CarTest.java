package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CarTest {


    @Test
    void getName() {
        Car car = new Car("name");
        assertThat(car.getName()).contains("name");
    }

    @Test
    void getOdometer() {
        // 랜덤으로 테스트
    }

    @Test
    void moveForward() {
        //랜덤으로 테스트
    }

    @Test
    void testToString() {
        Car car = new Car("name");
        assertThat(car.toString()).contains("name : ");
    }
}