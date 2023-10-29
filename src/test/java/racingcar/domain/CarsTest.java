package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.dto.CarDTO;

class CarsTest {
    Cars cars;
    Car car1;
    Car car2;

    @BeforeEach
    void beforeEach(){
        car1 = new Car("hoho");
        car2 = new Car("koko");
        cars = new Cars(Arrays.asList(car1, car2));
    }

    @Test
    void 같은_위치인_경우_승자(){
        // given
        List<CarDTO> expected = Arrays.asList(CarDTO.from(car1), CarDTO.from(car2));
        // then
        Assertions.assertThat(cars.getWinners())
                .usingElementComparator((a, b) -> {
                    return a.getName().compareTo(b.getName());
                }).isEqualTo(expected);
    }

}