package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.domain.dto.RaceResult;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RacingGameTest {
    @Test
    void 자동차_이름_리스트를_입력받아_레이싱_게임을_시작한_후_결과를_반환한다(){
        RacingGame racingGame = new RacingGame(List.of("pobi", "crong", "honux"));
        assertThat(racingGame.start(1)).isInstanceOf(RaceResult.class);
    }
}