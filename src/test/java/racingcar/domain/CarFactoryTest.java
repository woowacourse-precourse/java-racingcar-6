package racingcar.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarFactoryTest {

    private static final Name POBI = new Name("pobi");
    private static final Name WONI = new Name("woni");

    @Test
    public void 자동차_변환_테스트() {
        // given
        final List<Name> namesOfCars = List.of(POBI, WONI);

        // when
        final List<Car> cars = CarFactory.generateCar(namesOfCars);

        // then
        Assertions.assertThat(cars).hasSize(2);
    }
}