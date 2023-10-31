package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.strategy.AlwaysMoveStrategy;

class CarsTest {
    private Cars fullCars;
    private Car car1;
    private Car car2;

    @BeforeEach
    void setup() {
        // Given: 공통 초기 상태 설정

        car1 = Car.of(Name.from("차1"), AlwaysMoveStrategy.getInstance());
        car2 = Car.of(Name.from("차2"), AlwaysMoveStrategy.getInstance());
        Car car3 = Car.of(Name.from("차3"), AlwaysMoveStrategy.getInstance());

        car1.attemptMove();  // car1: 1 step
        car2.attemptMove();  // car2: 1 step
        car3.attemptMove();  // car3: 1 step
        car3.attemptMove();  // car3: 2 steps

        fullCars = Cars.from(List.of(car1, car2, car3));
    }

    @Test
    void 최대_step_구하기() {
        // When
        List<Car> carsWithMaxStep = fullCars.getCarsWithMaxStep();

        // Then
        assertEquals(1, carsWithMaxStep.size());
        assertEquals(2, carsWithMaxStep.get(0).getStep());
    }

    @Test
    void 빈_객체_생성_예외_처리() {
        // Given
        List<Car> list = List.of();

        // Then
        assertThrows(IllegalArgumentException.class, () -> Cars.from(list));
    }

    @Test
    void 반복자_동작() {
        // When
        Iterator<Car> carIterator = fullCars.iterator();

        // Then
        assertTrue(carIterator.hasNext());
        assertEquals(car1, carIterator.next());
        assertTrue(carIterator.hasNext());
        assertEquals(car2, carIterator.next());
    }
}