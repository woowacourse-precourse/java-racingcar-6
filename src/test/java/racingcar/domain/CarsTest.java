package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.dto.output.CarDto;
import racingcar.domain.dto.output.CarsDto;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    @Test
    @DisplayName("Cars 객체 생성")
    void test() {
        //given
        List<String> input = List.of("a", "b", "c");
        //when
        Cars cars = new Cars(input);
        CarsDto carsDto = cars.toCarsDto();
        CarDto firstCarDto = carsDto.carDtoList().get(0);
        CarDto secondCarDto = carsDto.carDtoList().get(1);
        CarDto thirdCarDto = carsDto.carDtoList().get(2);
        //then
        assertThat(cars).extracting("carList").isNotNull();
        assertThat(firstCarDto.name()).isEqualTo("a");
        assertThat(secondCarDto.name()).isEqualTo("b");
        assertThat(thirdCarDto.name()).isEqualTo("c");
    }
}