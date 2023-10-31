package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.CarStatus;
import racingcar.dto.RaceResult;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest extends IOTest {

    @DisplayName("경주 진행 결과를 받으면, 경주에 참여한 자동차 이름과 전진한 거리를 출력한다.")
    @Test
    void Given_RaceResult_When_printRaceResult_Then_PrintCarNameAndForwardDistance() throws Exception {
        // Given
        String carName = "edgar";
        int forwardDistance = 5;
        String expectedDistancePrint = "-".repeat(forwardDistance);
        List<RaceResult> raceResults = setTestRaceResultCase(carName, forwardDistance);
        OutputView outputView = new OutputView();

        // When
        outputView.printRaceResult(raceResults);

        // Then
        String printRaceResultMessage = getOutput();
        assertThat(printRaceResultMessage).contains(carName, expectedDistancePrint);
    }

    private List<RaceResult> setTestRaceResultCase(String carName, int distance) {
        CarStatus carStatus = new CarStatus(carName, distance);
        RaceResult raceResult = new RaceResult(1, List.of(carStatus));
        return List.of(raceResult);
    }

    @DisplayName("경주 우승자 목록을 받으면, 우승자 목록을 출력한다.")
    @Test
    void Given_WinnerList_When_printWinners_Then_Print() throws Exception {
        // Given
        String winner1 = "edgar";
        String winner2 = "kmo";
        List<String> winners = List.of(winner1, winner2);
        OutputView outputView = new OutputView();

        // When
        outputView.printWinners(winners);

        // Then
        String printWinnersMessage = getOutput();
        assertThat(printWinnersMessage).contains(winner1, winner2);
    }
}
