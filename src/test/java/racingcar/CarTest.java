package racingcar;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

final class CarTest {

    @Test
    void 이름이_null인_차는_인스턴스화_될때_에러가_발생한다() {
        assertThrows(IllegalArgumentException.class, () -> new Car(null));
    }

    @Test
    void 요구사항에_맞는_이름으로_인스턴스화할시_예외가_발생하지_않는다() {
        assertDoesNotThrow(() -> new Car("woowa"));
    }

    @Test
    void 동일한_이름을_가진_차는_동일한_객체로_인식한다() {
        String sameName = "동일한이름";
        Car car1 = new Car(sameName);
        Car car2 = new Car(sameName);

        assertEquals(car1, car2);
    }

    @Test
    void 동일한_이름을_가진_차는_Hash_자료구조에서도_동일한_객체로_인식된다() {
        String sameName = "동일한이름";
        Car car1 = new Car(sameName);
        Car car2 = new Car(sameName);
        Set<Car> set = new HashSet<>();

        set.add(car1);
        set.add(car2);

        assertEquals(set.size(), 1);
    }

    @Test
    void 자신의_현재상태를_출력형식에_맞는_String으로_반환한다() {
        String expected = "woowa : --";
        Car car = new Car("woowa");
        car.move();
        car.move();

        assertEquals(expected, car.currentStatus());
    }

    @Test
    void 선두라면_true를_반환한다() {
        Car car = new Car("name");
        int front = 2;

        car.move();
        car.move();

        assertTrue(car.isFront(front));
    }

    @Test
    void 선두가_아니라면_false를_반환한다() {
        Car car = new Car("name");
        int front = 2;

        car.move();

        assertFalse(car.isFront(front));
    }
}
