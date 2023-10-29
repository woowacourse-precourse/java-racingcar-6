package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class NavigationTest {

    @Test
    public void 자동차들을_이동() {
        List<Car> cars = List.of(
                new Car(new TestNumberGenerator(5)),
                new Car(new TestNumberGenerator(4)),
                new Car(new TestNumberGenerator(9)));
        Navigation navigation = new Navigation(cars);

        navigation.moveAll();

        List<Car> list = navigation.getList();
        assertThat(list).filteredOn(car -> car.getLocation() != 0).hasSize(2);
    }

}
