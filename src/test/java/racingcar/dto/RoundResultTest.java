package racingcar.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RoundResultTest {

    @Test
    @DisplayName("라운드 결과 출력을 위한 레코드")
    void givenNameAndPosition_whenCreateRoundResult_thenReturnCorrectValue() {
        // given
        RoundResult roundResult = new RoundResult("pobi", 3);

        // when & then
        assertThat(roundResult.name()).isEqualTo("pobi");
        assertThat(roundResult.position()).isEqualTo(3);
    }

}
