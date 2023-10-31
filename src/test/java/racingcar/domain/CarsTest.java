package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.dto.CarDto;

class CarsTest {
    @Test
    void 주어진_자동차_이름_목록을_통해_객체를_생성한다() {
        List<String> carNames = List.of("apple", "melon", "lime");
        Cars cars = Cars.from(carNames);

        assertThat(cars.dtos())
                .extracting(CarDto::name)
                .containsExactlyInAnyOrderElementsOf(carNames);
    }
}
