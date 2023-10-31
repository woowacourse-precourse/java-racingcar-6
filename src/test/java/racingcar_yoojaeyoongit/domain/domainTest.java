package racingcar_yoojaeyoongit.domain;

import org.junit.jupiter.api.Test;
import racingcar.model.CarRacingGame;
import racingcar.model.RacingCar;
import racingcar.service.RacingGameService;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class domainTest {
    RacingGameService racingGameService = new RacingGameService();

    @Test
    void 레이싱게임_생성_확인() {
        //given
        String carNameListInput = "name1,name2,name3";
        int raceCountInput = 8;
        //when
        CarRacingGame racingGame = racingGameService.createRacingGame(carNameListInput, raceCountInput);
        //then
        ArrayList<RacingCar> participationConfirmedCarList = racingGame.getParticipationConfirmedCarList();
        int raceCount = racingGame.getRaceCount();
        assertNotNull(participationConfirmedCarList);
        assertThat(raceCount).isEqualTo(8);
    }

    @Test
    void 유저입력_자동차_생성_확인() {
        //given
        String carNameListInput = "name1,name2,name3";
        int raceCountInput = 8;
        //when
        CarRacingGame racingGame = racingGameService.createRacingGame(carNameListInput, raceCountInput);
        //then
        ArrayList<RacingCar> participationConfirmedCarList = racingGame.getParticipationConfirmedCarList();
        for (RacingCar racingCar : participationConfirmedCarList) {
            assertThat(racingCar.getName()).isIn("name1", "name2", "name3");
        }
    }
}
