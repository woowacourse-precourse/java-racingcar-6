package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.dto.CarDTO;

class CarsTest {
    Cars cars;
    Car car1;
    Car car2;

    @BeforeEach
    void beforeEach() {
        car1 = new Car("hoho");
        car2 = new Car("koko");
        cars = new Cars(Arrays.asList(car1, car2));
    }

    @Test
    void 같은_위치인_경우_승자() {
        // then
        List<CarDTO> expected = Arrays.asList(CarDTO.from(car1), CarDTO.from(car2));
        Assertions.assertThat(cars.getWinners())
                .usingElementComparator((a, b) -> {
                    return a.getName().compareTo(b.getName());
                }).isEqualTo(expected);
    }

    @Test
    void 다른_위치인_경우_승자() {
        // given
        IntStream.range(0, 5).forEach(i -> {
            car1.move(4);
        });
        // then
        List<CarDTO> expected = Arrays.asList(CarDTO.from(car1));
        Assertions.assertThat(cars.getWinners())
                .usingElementComparator((a, b) -> {
                    return a.getName().compareTo(b.getName());
                }).isEqualTo(expected);
    }

    @Test
    void 가장_먼_거리_구하기() {
        // given
        IntStream.range(0, 5).forEach(i -> {
            car1.move(4);
            car2.move(3);
        });
        // then
        Assertions.assertThat(cars.getMaxDistance()).isEqualTo(5);
    }

}