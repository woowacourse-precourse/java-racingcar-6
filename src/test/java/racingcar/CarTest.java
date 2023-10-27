package racingcar;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

final class CarTest {

    @Test
    void 이름이_null인_차는_인스턴스화_될때_에러가_발생한다() {
        assertThrows(IllegalArgumentException.class, () -> new Car(null));
    }

    @Test
    void 동일한_이름을_가진_차는_동일한_객체로_인식한다() {
        Name sameName = new Name("동일한이름");
        Car car1 = new Car(sameName);
        Car car2 = new Car(sameName);

        assertEquals(car1, car2);
    }

    @Test
    void 동일한_이름을_가진_차는_Hash_자료구조에서도_동일한_객체로_인식된다() {
        Name sameName = new Name("동일한이름");
        Car car1 = new Car(sameName);
        Car car2 = new Car(sameName);
        Set<Car> set = new HashSet<>();

        set.add(car1);
        set.add(car2);

        assertEquals(set.size(), 1);
    }
}
