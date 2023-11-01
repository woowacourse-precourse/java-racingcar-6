package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void 우승자일때_참_반환하는_테스트() {
        Position maxPosition = new Position(1);
        Car car = new Car("a");
        car.movePosition();
        assertTrue(car.isWinner(maxPosition));
    }

    @Test
    void 우승자_아닐때_거짓_반환하는_테스트() {
        Position maxPosition = new Position(1);
        Car car = new Car("a");
        assertFalse(car.isWinner(maxPosition));
    }

    @Test
    void 위치비교_메서드_거짓_반환하는_테스트() {
        Position maxPosition = new Position(10);
        Car car = new Car("a");
        car.movePosition();
        assertFalse(car.isGreaterPositionThan(maxPosition));
    }

    @Test
    void 위치비교_메서드_참_반환하는_테스트() {
        Position maxPosition = new Position(1);
        Car car = new Car("a");
        car.movePosition();
        car.movePosition();
        assertTrue(car.isGreaterPositionThan(maxPosition));
    }

    @Test
    void 자동차_이동_테스트() {
        Car car = new Car("a");
        car.movePosition();
        car.movePosition();
        assertTrue(car.position().equals(new Position(2)));
    }

    @Test
    void 자동차_이름_잘_받아오는지_테스트() {
        Car car = new Car("a");
        assertEquals("a", car.getNameFormat());
    }

    @Test
    void 자동차_위치_결과_포맷으로_변환하는_테스트() {
        Car car = new Car("a");
        car.movePosition();
        car.movePosition();
        car.movePosition();
        assertEquals("---", car.position().format());
    }

}
