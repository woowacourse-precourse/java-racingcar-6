package racingcar.serviceTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import racingcar.service.RacingCarService;

public class RacingCarServiceTest {
    private RacingCarService racingCarService;

    @BeforeEach
    public void genereteRacingService() {
        racingCarService = new RacingCarService();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void 램덤수가_4이하인_움직임_판단_테스트(int randomNum) {

        assertThat(racingCarService.judgeMove(randomNum)).isFalse();

    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 램덤수가_4이상인_움직임_판단_테스트(int randomNum) {

        assertThat(racingCarService.judgeMove(randomNum)).isTrue();

    }

    @Test
    @DisplayName("결과판단 테스트")
    void 결과_판단_테스트() {

        RacingCarService gameResult = Mockito.spy(racingCarService);
        Mockito.when(gameResult.generateRandomNum()).thenReturn(8).thenReturn(5).thenReturn(7);

        gameResult.generateCars("car1,car2,car3");

        HashMap<String, String> expectedGameResult = new HashMap<>();
        expectedGameResult.put("car1", "-"); // 이동
        expectedGameResult.put("car2", "-"); // 이동
        expectedGameResult.put("car3", "-"); // 이동

        HashMap<String, String> result = gameResult.judgeResult();

        assertThat(result).isEqualTo(expectedGameResult);
    }

    @Test
    @DisplayName("단독 우승자판단 테스트")
    void 단독_우승자_판단_테스트() throws IllegalAccessException, NoSuchFieldException {

        HashMap<String, String> gameResult = new HashMap<>();
        gameResult.put("car1", "---");
        gameResult.put("car2", "------");
        gameResult.put("car3", "---");

        Field field = RacingCarService.class.getDeclaredField("gameResult");
        field.setAccessible(true);
        field.set(racingCarService, gameResult);

        List<String> winners = racingCarService.judgeWinners();

        List<String> expectedWinners = new ArrayList<>();
        expectedWinners.add("car2");

        assertThat(expectedWinners).isEqualTo(winners);
    }

    @Test
    @DisplayName("공동 우승자판단 테스트")
    void 공동_우승자_판단_테스트() throws IllegalAccessException, NoSuchFieldException {

        HashMap<String, String> gameResult = new HashMap<>();
        gameResult.put("car1", "---");
        gameResult.put("car2", "------");
        gameResult.put("car3", "------");

        Field field = RacingCarService.class.getDeclaredField("gameResult");
        field.setAccessible(true);
        field.set(racingCarService, gameResult);

        List<String> winners = racingCarService.judgeWinners();

        List<String> expectedWinners = new ArrayList<>();
        expectedWinners.add("car2");
        expectedWinners.add("car3");

        assertThat(expectedWinners).isEqualTo(winners);
    }
}
