package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsGameCountTest {

    @Test
    @DisplayName("숫자가 아니므로 익셉션 발생")
    void convertToInt() throws Exception {
        //given
        String input = "a";
        //when

        //then
        assertThatThrownBy(() -> new CarsGameCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자");
    }

    @Test
    @DisplayName("횟수 저장 완료")
    void 횟수_저장_완료() throws Exception {
        //given
        String input = "3";
        //when
        CarsGameCount carsGameCount = new CarsGameCount(input);
        //then
        assertThat(carsGameCount.getCount()).isEqualTo(3);
    }

}