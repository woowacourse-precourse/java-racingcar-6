package racingcar.domain.round;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RoundDtoMapperTest {

    @Test
    @DisplayName("RoundDto로부터 문자열을 추출하여 정수로 변환합니다.")
    void mapToRound() {
        // GIVEN
        String round = "2";
        int expectedRound = 2;
        RoundDto roundDto = new RoundDto(round);

        // WHEN
        int actualRound = RoundDtoMapper.mapToRound(roundDto);

        // THEN
        assertEquals(expectedRound, actualRound);
    }
}