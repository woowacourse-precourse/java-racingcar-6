package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.function.BooleanSupplier;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.CarStatus;
import racingcar.dto.RaceStatus;
import racingcar.dto.WinnerNames;

class CarsTest {
    @Test
    @DisplayName("글자수 제한 넘어간 이름으로 인해 Cars 생성 불가 테스트")
    void OverNameMaxLengthTest() {
        var Names = List.of("문제없음", "글자수제한넘어감", "세글자");
        assertThrows(IllegalArgumentException.class, () -> Cars.createCarsUsingCarNames(Names));
    }

    @Test
    @DisplayName("Cars 생성 테스트")
    void createCarsTest() throws Exception {
        var Names = List.of("문제없음", "다섯자까지", "세글자");
        assertDoesNotThrow(() -> Cars.createCarsUsingCarNames(Names));
    }

    @Test
    @DisplayName("경주 룰에 따른 자동차 운전 확인 테스트")
    void driveCarsByRuleTest() {
        BooleanSupplier raceRule = mock(BooleanSupplier.class);
        when(raceRule.getAsBoolean())
                .thenReturn(true, false);

        String driveCarName = "주행";
        String stopCarName = "멈춤";

        Cars cars = Cars.createCarsUsingCarNames(List.of(driveCarName, stopCarName));
        RaceStatus raceStatus = cars.driveCarsByRule(raceRule);
        List<CarStatus> carStatuses = raceStatus.getCarStatuses();

        CarStatus driveCarStatus = carStatuses.get(0);
        assertThat(driveCarStatus.getName()).isEqualTo(driveCarName);
        assertThat(driveCarStatus.getDriveCount()).isEqualTo(1);

        CarStatus stopCarStatus = carStatuses.get(1);
        assertThat(stopCarStatus.getName()).isEqualTo(stopCarName);
        assertThat(stopCarStatus.getDriveCount()).isZero();
    }

    @Test
    @DisplayName("공동 우승자 확인 테스트")
    void getWinnerNamesTest() {
        BooleanSupplier raceRule = mock(BooleanSupplier.class);
        when(raceRule.getAsBoolean())
                .thenReturn(true, false, true);

        String firstWinnerName = "우승자1";
        String sadManName = "아쉬운자";
        String secondWinnerName = "우승자2";

        Cars cars = Cars.createCarsUsingCarNames(List.of(firstWinnerName, sadManName, secondWinnerName));
        cars.driveCarsByRule(raceRule);
        WinnerNames winnerNames = cars.getWinnerNames();
        assertThat(winnerNames.getWinnerNames()).isEqualTo(List.of("우승자1", "우승자2"));
    }
}