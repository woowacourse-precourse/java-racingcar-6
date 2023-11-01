package racingcar.io.enums;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.generic.RacerProgress;
import racingcar.io.views.enums.RaceTotalProgressViewMessage;

class RaceTotalProgressViewMessageTest {

    @Test
    void makeRacingRecord로_레이싱기록을_볼수있다() {
        String expected = "최길동 : ---";
        RacerProgress racerProgress = new RacerProgress("최길동", 3);

        String actual = RaceTotalProgressViewMessage.makeRacingRecord(racerProgress);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void makeWinnersMessage로_최종우승자발표메시지를볼수있다() {
        String winners = "고길동";
        String expected = "\n" + "최종 우승자 : " + winners;

        String actual = RaceTotalProgressViewMessage.makeWinnersMessage(winners);

        assertThat(actual).isEqualTo(expected);
    }

}