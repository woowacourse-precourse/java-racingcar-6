package racingcar.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingCar;

public class RacingTest {
    RacingService racingService = new RacingService();

    @DisplayName("입력한 숫자 만큼 실행합니다.")
    @Test
    public void 입력한_시도_회수_만큼_실행_테스트() {
        int count = 5;
        List<RacingCar> racingCars = Arrays.asList(new RacingCar("wlgus"), new RacingCar("wltn"),
                new RacingCar("gustn"));

        String result = racingService.startRace(count, racingCars);

        int startIndex = 0;
        int actualCount = 0;
        while (startIndex < result.length()) {
            int index = result.indexOf("wlgus", startIndex);
            if (index == -1) {
                break;
            }
            actualCount++;
            startIndex = index + "wlgus".length();
        }

        assertThat(actualCount).isEqualTo(count);
    }
}
