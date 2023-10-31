package racingcar.serviceTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import racingcar.model.Cars;
import racingcar.service.RacingCarService;

public class RacingCarServiceTest {
    private RacingCarService racingCarService;

    @BeforeEach
    public void genereteRacingService() {
        racingCarService = new RacingCarService();
    }

    @Test
    @DisplayName("결과판단 테스트")
    void 결과_판단_테스트() {

        RacingCarService gameResult = Mockito.spy(racingCarService);
        Mockito.when(gameResult.generateRandomNum()).thenReturn(8).thenReturn(5).thenReturn(7);

        Cars cars = gameResult.generateCars("car1,car2,car3");

        HashMap<String, String> expectedGameResult = new HashMap<>();
        expectedGameResult.put("car1", "-");
        expectedGameResult.put("car2", "-");
        expectedGameResult.put("car3", "-");

        HashMap<String, String> result = gameResult.judgeResult(cars.getCarsStatus());

        assertThat(result).isEqualTo(expectedGameResult);
    }

    @Test
    @DisplayName("단독 우승자판단 테스트")
    void 단독_우승자_판단_테스트() {

        HashMap<String, String> finalResult = new HashMap<>();
        finalResult.put("car1", "---");
        finalResult.put("car2", "------");
        finalResult.put("car3", "---");

        List<String> winners = racingCarService.judgeWinners(finalResult);

        List<String> expectedWinners = new ArrayList<>();
        expectedWinners.add("car2");

        assertThat(expectedWinners).isEqualTo(winners);
    }

    @Test
    @DisplayName("공동 우승자판단 테스트")
    void 공동_우승자_판단_테스트() {

        HashMap<String, String> finalResult = new HashMap<>();
        finalResult.put("car1", "----");
        finalResult.put("car2", "------");
        finalResult.put("car3", "------");

        List<String> winners = racingCarService.judgeWinners(finalResult);

        List<String> expectedWinners = new ArrayList<>();
        expectedWinners.add("car2");
        expectedWinners.add("car3");

        assertThat(expectedWinners).isEqualTo(winners);
    }
}
