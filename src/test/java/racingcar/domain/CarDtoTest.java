package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarDtoTest {

    @DisplayName("CarDto 객체의 올바른 필드를 반환한다.")
    @Test
    void getName() {
        // given
        String name = "pobi";
        int distance = 5;

        CarDto carDto = CarDto.convertCarDto(name, distance);

        // when
        String carDtoName = carDto.getName();
        int carDtoDistance = carDto.getDistance();

        // then
        Assertions.assertThat(carDtoName).isEqualTo(name);
        Assertions.assertThat(carDtoDistance).isEqualTo(distance);
    }

}