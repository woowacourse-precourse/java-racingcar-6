package racingcar.domain.car;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.TestNumberGenerator;

class NavigationTest {

    @Test
    public void 자동차들을_이동() {
        List<Car> cars = List.of(
                new Car("pobi", new TestNumberGenerator(5)),
                new Car("json", new TestNumberGenerator(3)),
                new Car("hun", new TestNumberGenerator(9)));
        Navigation navigation = new Navigation(cars);

        navigation.moveAll();

        List<Car> list = navigation.getList();
        assertThat(list).filteredOn(car -> car.getLocation() != 0).hasSize(2);
    }

    @Test
    public void 같은_이름이있을_시_예외() {
        List<Car> cars = List.of(
                new Car("pobi", new TestNumberGenerator(5)),
                new Car("pobi", new TestNumberGenerator(3)),
                new Car("hun", new TestNumberGenerator(9)));

        assertThatThrownBy(() -> new Navigation(cars)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 우승자를_반환한다() {
        List<Car> cars = List.of(
                new Car("pobi", new TestNumberGenerator(5)),
                new Car("jun", new TestNumberGenerator(3)));
        Navigation navigation = new Navigation(cars);

        navigation.moveAll();

        List<Car> result = navigation.determineWinner();
        assertThat(result).hasSize(1);
        assertThat(result.get(0).getName()).isEqualTo("pobi");
    }

}
