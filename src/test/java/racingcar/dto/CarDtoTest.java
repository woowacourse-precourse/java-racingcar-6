package racingcar.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarDtoTest {

    @Test
    @DisplayName("라운드 결과 출력을 위한 레코드")
    void givenNameAndPosition_whenCreateRoundResult_thenReturnCorrectValue() {
        // given
        String name = "pobi";
        int position = 3;

        // when
        CarDto carDto = new CarDto(name, position);

        // then
        assertThat(carDto.name()).isEqualTo("pobi");
        assertThat(carDto.position()).isEqualTo(3);
    }

}
