package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RacingResultTest {
    @Test
    public void 전진_결과_테스트() {
        //given
        RacingResult racingResult = new RacingResult(new CarNames("pobi,woni,jun"));

        //when
        racingResult.moveForward("pobi");
        racingResult.moveForward("woni");
        racingResult.moveForward("jun");
        racingResult.moveForward("pobi");
        racingResult.moveForward("jun");
        racingResult.moveForward("pobi");

        //then
        Assertions.assertThat(racingResult.getResult().get("pobi")).isEqualTo(3);
        Assertions.assertThat(racingResult.getResult().get("woni")).isEqualTo(1);
        Assertions.assertThat(racingResult.getResult().get("jun")).isEqualTo(2);
    }

    @Test
    public void 우승자_확인_테스트() {
        //given
        List<String> winners;
        RacingResult racingResult = new RacingResult(new CarNames("pobi,woni,jun"));

        //when
        racingResult.moveForward("pobi");
        racingResult.moveForward("woni");
        racingResult.moveForward("jun");
        racingResult.moveForward("pobi");
        racingResult.moveForward("jun");
        racingResult.moveForward("pobi");
        racingResult.moveForward("woni");
        racingResult.moveForward("jun");

        winners = racingResult.getWinners();

        //then
        Assertions.assertThat(winners.size()).isEqualTo(2);
        Assertions.assertThat(winners.contains("pobi")).isTrue();
        Assertions.assertThat(winners.contains("jun")).isTrue();
        Assertions.assertThat(winners.contains("woni")).isFalse();
    }
}
