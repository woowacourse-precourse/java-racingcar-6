package racingcar.domain.dto.input;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsRequestDtoTest {
    @Test
    @DisplayName("이름 빈 문자열 검사")
    void testNameIfIsEmpty() {
        //given
        String inputNames = "";
        CarsRequestDto carsRequestDto = new CarsRequestDto(inputNames);
        //when
        //then
        assertThatThrownBy(carsRequestDto::toCars)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력값이 빈 문자열 또는 공백입니다.\n");
    }

}