package racingcar.service;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Engine;
import racingcar.domain.RacingCars;

class RacingGameServiceTest {

    static final Long MOVE = 1L;
    static final Long STOP = 0L;
    RacingGameService racingGameService = new RacingGameService();

    @Test
    @DisplayName("[성공 테스트] 자동차 3대 중 2대만 전진하는 테스트")
    void playOneTimeCarRaceTest() {
        // given
        RacingCars racingCars = new RacingCars(List.of("june", "jayZ", "White"), new CustomEngine());
        // when
        OneGameResultDto resultDto = racingGameService.playOneTimeCarRace(racingCars);
        // then
        Assertions.assertThat(resultDto.getTotalMoveCounts()).containsExactly(MOVE, STOP, MOVE);
    }

    static class CustomEngine implements Engine {

        List<Integer> enginePowers = Lists.newArrayList(4, 3, 8);

        @Override
        public int generateNumber() {
            return enginePowers.remove(0);
        }
    }
}

