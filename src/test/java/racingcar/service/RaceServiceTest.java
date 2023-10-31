package racingcar.service;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.Progress;

class RaceServiceTest {
    private final RaceService raceService = new RaceService();


    @Test
    @DisplayName("경주차를 한 번 랜덤하게 이동시키고 난 이후의 결과를 List<Progress>로 반환받을 수 있다.")
    public void should_returnProgressList_when_moveCars() {
        //given
        List<String> carNames = getCarNames();
        raceService.init(carNames);

        //when
        List<Progress> progressList = raceService.moveCars();

        //then
        assertThat(progressList).allSatisfy(progress -> {
            assertThat(progress.carName()).isNotBlank();
            assertThat(progress.distance()).isNotNegative();
        });
    }

    @Test
    @DisplayName("경주의 최종 우승자들을 반환받은 List의 크기는 1 이상이어야 한다")
    public void should_returnWinners_when_endGame() {
        //given
        List<String> carNames = getCarNames();
        raceService.init(carNames);

        //when
        for (int i = 0; i < 5; ++i) {
            raceService.moveCars();
        }
        List<String> winner = raceService.getWinner();

        //then
        assertThat(winner.size()).isGreaterThan(0);
    }


    private List<String> getCarNames() {
        return Arrays.asList("pobi", "crong", "left");
    }
}