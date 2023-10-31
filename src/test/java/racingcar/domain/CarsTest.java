package racingcar.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {
    @Test
    void 중복된_자동차가_존재할_경우_예외가_발생한다() {
        // given
        String name = "pobi";
        Car car1 = new Car(name);
        Car car2 = new Car(name);
        Car car3 = new Car("woni");
        List<Car> cars = List.of(car1, car2, car3);

        // when & then
        assertThatThrownBy(() -> new Cars(cars))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_대수가_2대_미만일_경우_예외가_발생한다() {
        // given
        List<Car> cars = List.of(new Car("pobi"));

        // when & then
        assertThatThrownBy(() -> new Cars(cars))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_대수만큼_사이즈를_반환한다() {
        // given
        int carCount = 10;
        Cars cars = createCars(carCount);

        // when
        int size = cars.size();

        // then
        assertThat(size).isEqualTo(carCount);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:car0", "1:car1", "2:car2"}, delimiter = ':')
    void 인덱스에_해당하는_자동차를_반환한다(int index, String expectedName) {
        // given
        Cars cars = createCars(3);

        // when
        Car car = cars.findCar(index);

        // then
        assertThat(car.getName()).isEqualTo(expectedName);
    }

    @Test
    void 자동차_중_가장_많은_전진_횟수를_반환한다() {
        // given
        Cars cars = createCars(3);
        int movedCount = 5;
        IntStream.range(0, movedCount)
                .forEach(i -> cars.findCar(0).move());

        // when
        int maxMovedCount = cars.getMaxMovedCount();

        // then
        assertThat(maxMovedCount).isEqualTo(movedCount);
    }

    private Cars createCars(int createCount) {
        List<Car> cars = IntStream.range(0, createCount)
                .mapToObj(i -> new Car("car" + i))
                .toList();
        return new Cars(cars);
    }
}
