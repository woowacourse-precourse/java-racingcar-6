package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    Car car = new Car("test1");

    @DisplayName("자동차 이름은 객체 생성 시 name 필드에 저장된다.")
    @Test
    void getName() {
        assertEquals("test1", car.getName());
    }

    @DisplayName("자동차의 위치는 객체 생성 시 position 필드에 저장된다.")
    @Test
    void getPosition() {
        assertEquals(0, car.getPosition());
    }

    @DisplayName("랜덤 생성된 숫자가 4 이상이면 자동차는 전진한다.")
    @Test
    void move() {
        car.move();

        assertTrue(car.getPosition() >= 0 && car.getPosition() <= 1);
    }

    @DisplayName("랜덤 숫자는 0~9 사이의 범위에서 생성된다.")
    @Test
    void createRandomNumber() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);

        assertTrue(randomNumber >= 0 && randomNumber <= 9);
    }


}