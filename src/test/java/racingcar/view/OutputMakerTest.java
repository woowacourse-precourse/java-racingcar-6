package racingcar.view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.response.CarInfo;
import racingcar.dto.response.RacingStatus;
import racingcar.dto.response.WinnerNames;

class OutputMakerTest {

    private final OutputMaker outputMaker = new OutputMaker();
    private final List<String> NAMES = List.of("car1", "car2");

    @Test
    @DisplayName("makeRacingWinnerOutput 메서드에 WinnerNames를 넣으면 올바른 문자열이 생성된다.")
    void makeRacingWinnerOutput() {
        // Given
        WinnerNames winnerNames = mock(WinnerNames.class);
        when(winnerNames.getWinnerNames()).thenReturn(NAMES);

        // When
        String output = outputMaker.makeRacingWinnerOutput(winnerNames);

        // Then
        assertEquals("최종 우승자 : car1, car2", output);
    }

    @Test
    @DisplayName("makeRacingStatusOutput 메서드에 RacingStatus를 넣으면 올바른 문자열이 생성된다.")
    void makeRacingStatusOutput() {
        // Given
        CarInfo carInfo1 = mock(CarInfo.class);
        CarInfo carInfo2 = mock(CarInfo.class);
        when(carInfo1.getName()).thenReturn("car1");
        when(carInfo1.getMoveCount()).thenReturn(2);
        when(carInfo2.getName()).thenReturn("car2");
        when(carInfo2.getMoveCount()).thenReturn(3);

        RacingStatus racingStatus = mock(RacingStatus.class);
        when(racingStatus.getCarInfos()).thenReturn(List.of(carInfo1, carInfo2));

        // When
        String output = outputMaker.makeRacingStatusOutput(racingStatus);

        // Then
        assertEquals("car1 : --\ncar2 : ---\n", output);
    }
}
