package racingcar.Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {
    @Test
    void 인스턴스_생성_및_이름_호출(){
        Car car = new Car("test");
        assertEquals("test",car.getName());
    }

    @Test
    void 멈춤_조건(){
        int stop = 0;
        Car car = new Car("test");
        assertEquals(0,car.checkForwardOrStop(1));
    }

    @Test
    void 전진_조건(){
        int forward = 1;
        Car car = new Car("test");
        assertEquals(forward,car.checkForwardOrStop(4));
    }

}