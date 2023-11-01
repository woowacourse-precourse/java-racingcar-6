package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarsCopyListTest {
    List<Car> original;
    Cars cars;

    @BeforeEach
    void setUp() {
        original = new ArrayList<>();
        original.add(new Car("1"));
        cars = new Cars(original);
    }

    @Test
    void copyList_복사본은_원본과_다른_참조를_갖는다() {
        original.add(new Car("2"));

        List<Car> copy = cars.copyList();

        assertThat(copy).isNotSameAs(original);
        assertThat(copy.size()).isNotEqualTo(original.size());
    }

    @Test
    void copyList_깊은_복사가_일어난다() {
        Car car1 = original.get(0);
        car1.moveForward();

        List<Car> copy = cars.copyList();
        Car car2 = copy.get(0);

        assertThat(car2).isNotSameAs(car1);
        assertThat(car2.getName()).isEqualTo(car1.getName());
        assertThat(car2.getForwardCount()).isNotEqualTo(car1.getForwardCount());
    }

    @Test
    void copyList_매번_새로운_복사본이_생성된다() {
        List<Car> copy1 = cars.copyList();
        Car car1 = copy1.get(0);
        car1.moveForward();

        List<Car> copy2 = cars.copyList();
        Car car2 = copy2.get(0);

        assertThat(car2).isNotSameAs(car1);
        assertThat(car2.getName()).isEqualTo(car1.getName());
        assertThat(car2.getForwardCount()).isNotEqualTo(car1.getForwardCount());
    }
}
