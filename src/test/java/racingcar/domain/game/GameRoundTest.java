package racingcar.domain.game;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.CarInfo;
import racingcar.dto.Round;

class GameRoundTest {
    private CarInfo carInfo = CarInfo.getInstance();
    private Round currentRound = new Round(1);

    @DisplayName("현재 라운드를 얻을 수 있다.")
    @Test
    void getCurrentRound() {
        //given
        GameRound gameRound = new GameRound(currentRound);

        //when
        int currentRound = gameRound.getCurrentRound();

        //then
        assertThat(currentRound).isEqualTo(1);
    }

    @DisplayName("다음 라운드로 패스할 수 있다.")
    @Test
    void passCurrentRound() {
        //given
        GameRound gameRound = new GameRound(currentRound);

        //when
        gameRound.passCurrentRound();

        //then
        assertThat(gameRound.getCurrentRound()).isEqualTo(2);
    }
}