package racingcar.games.racing.util;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingFormatterTest {

    @Test
    @DisplayName("자동차 이름들의 정상 입력에 대한 출력 검증")
    public void reformatNormalCarNames() {
        //given
        RacingFormatter formatter = new RacingFormatter();

        //when
        List<String> carNames = formatter.reformatCarNames("poby,고죠,해광");

        //then
        assertThat(carNames.size()).isEqualTo(3);
        assertThat(carNames).containsExactly("poby", "고죠", "해광");
    }
}