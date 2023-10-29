package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CountTest {

    @Test
    @DisplayName("숫자가 아니므로 익셉션 발생")
    void convertToInt() throws Exception {
        //given
        String input = "a";
        //when

        //then
        assertThatThrownBy(() -> new Count(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자");
    }

    @Test
    @DisplayName("횟수 저장 완료")
    void 횟수_저장_완료() throws Exception {
        //given
        String input = "3";
        //when
        Count count = new Count(input);
        //then
        assertThat(count.getCount()).isEqualTo(3);
    }

}