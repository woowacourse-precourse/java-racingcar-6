package racingcar.util;


import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.constant.RaceConfig.CONVERTING_SIGNS;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringFormatterTest {

    @DisplayName("자동차 이름과 위치표시자를 입력받아 문구를 출력한다.")
    @Test
    void raceResultFormat() {
        // given
        String name = "pobi";
        int position = 1;
        String expected = String.format("%s : %s%n", name, CONVERTING_SIGNS.repeat(position));

        // when
        String result = StringFormatter.raceResultFormat(name, position);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("우승자 이름을 입력받아 문구를 출력한다.")
    @Test
    void winnerFormat() {
        // given
    	String winner = "pobi";
        String expected = "최종 우승자 : " + winner;

        // when
        String result = StringFormatter.winnerFormat(winner);

        // then
        assertThat(result).isEqualTo(expected);
    }
}
