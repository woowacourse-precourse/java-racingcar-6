package racingcar.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarDtoTest {

    @Test
    @DisplayName("라운드 결과 출력을 위한 레코드")
    void givenNameAndPosition_whenCreateRoundResult_thenReturnCorrectValue() {
        // given
        CarDto carDto = new CarDto("pobi", 3);

        // when & then
        assertThat(carDto.name()).isEqualTo("pobi");
        assertThat(carDto.position()).isEqualTo(3);
    }

}
