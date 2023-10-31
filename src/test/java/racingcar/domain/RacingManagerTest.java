package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.service.dto.GameResult;
import racingcar.view.dto.CarNameList;

class RacingManagerTest {

    @DisplayName("이동 및 승자 계산 테스트")
    @Test
    public void 성공테스트_승자_계산() throws  Exception {
        //given
        String winnerName1 = "win1";
        String winnerName2 = "win2";
        String loserName = "lose";
        CarNameList carNameList = new CarNameList(List.of(winnerName1, winnerName2, loserName));
        RacingManager racingManager = new RacingManager(carNameList);

        int winnerNumber = 4;
        int loserNumber = 0;

        int expectedWinnerNumber = 2;
        int expectedWinnerDistance = 1;
        int expectedLoserDistance = 0;

        //when
        racingManager.moveEachCar(List.of(winnerNumber, winnerNumber, loserNumber));
        List<String> winners = racingManager.calculateWinner();
        GameResult result = racingManager.createResult();

        //then
        assertThat(winners.size()).isEqualTo(expectedWinnerNumber);
        assertThat(result.getDistance(winnerName1)).isEqualTo(expectedWinnerDistance);
        assertThat(result.getDistance(winnerName2)).isEqualTo(expectedWinnerDistance);
        assertThat(result.getDistance(loserName)).isEqualTo(expectedLoserDistance);
    }
}