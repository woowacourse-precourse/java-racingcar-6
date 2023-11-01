package racingcar.dto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;
import racingcar.domain.RandomNumberGenerator;

class CarsDtoTest {

    @DisplayName("CarsDto를 Cars로 생성할 수 있다.")
    @Test
    void from() {
        // given
        Cars cars = Cars.of(List.of("aaa","bbb","ccc"), new RandomNumberGenerator());

        // when
        CarsDto carsDto = CarsDto.from(cars);

        // then
        assertThat(carsDto.carDtos().size()).isEqualTo(3);

        assertThat(carsDto.carDtos().get(0).name()).isEqualTo("aaa");
        assertThat(carsDto.carDtos().get(0).position()).isEqualTo(0);

        assertThat(carsDto.carDtos().get(1).name()).isEqualTo("bbb");
        assertThat(carsDto.carDtos().get(1).position()).isEqualTo(0);

        assertThat(carsDto.carDtos().get(2).name()).isEqualTo("ccc");
        assertThat(carsDto.carDtos().get(2).position()).isEqualTo(0);
    }
}