package racingcar.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.entity.Car;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class CarRepositoryImplTest {

    Map<Long, Car> store = new HashMap<>();

    @BeforeEach
    void before() {
        store.put(0L, new Car(0L, "test0", 1));
        store.put(1L, new Car(1L, "test1", 2));
        store.put(2L, new Car(2L, "test2", 3));
    }

    @Test
    void updateTest() {
        Car car = store.get(0L);
        car.setDistance(car.getDistance() + 1);
        assertThat(car.getDistance()).isEqualTo(2);
        assertThat(store.get(0L).getDistance()).isEqualTo(2);
    }

    @Test
    void findByIdTest() {
        assertThat(store.get(2L).getId()).isEqualTo(2L);
    }

    @Test
    void findByAllTest() {
        List<Car> findAllCar = new ArrayList<>(store.values());
        assertThat(findAllCar.size()).isEqualTo(3);
    }
}