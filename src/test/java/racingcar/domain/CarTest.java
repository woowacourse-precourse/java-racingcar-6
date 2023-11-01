package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("testCat");
    }

    @Test
    void 자동차_객체_생성_시_주어진_이름을_정확히_저장하는지_확인() {
        assertEquals("testCat", car.getName());
    }

    @Test
    void 전진_명령을_4_이상으로_내렸을_때_자동차의_위치가_1_증가하는지_확인() {
        int initialPosition = car.getPosition();
        car.tryMove(4);
        assertEquals(initialPosition + 1, car.getPosition());
    }

    @Test
    void 전진_명령을_3_이하로_내렸을_때_자동차의_위치가_증가하지_않는지_확인() {
        int initialPosition = car.getPosition();
        car.tryMove(3);
        assertEquals(initialPosition, car.getPosition());
    }
}