package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.RandomNumberGenerator;

import java.util.LinkedHashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RacingCarGameServiceTest {

    private RacingCarGameService racingCarGameService;

    @BeforeEach
    void setUp() {
        racingCarGameService = new RacingCarGameService();
    }

    @Test
    @DisplayName("한 회차의 게임 진행에서 랜덤 숫자가 4 이상이면 전진하고, 3 이하이면 정지 상태를 유지한다. ")
    void should_MoveForward_When_FourOrMore() {
        RandomNumberGenerator randomNumberGenerator = mock(RandomNumberGenerator.class);
        when(randomNumberGenerator.getRandomNumber()).thenReturn(3, 4, 5);
        List<String> carNames = List.of("car1", "car2", "car3");
        LinkedHashMap<String, Integer> racingProgressStatus = new LinkedHashMap<>();
        racingProgressStatus.put("car1", 0);
        racingProgressStatus.put("car2", 1);
        racingProgressStatus.put("car3", 2);

        racingCarGameService.playSingleGame(randomNumberGenerator, carNames, racingProgressStatus);

        assertThat(racingProgressStatus.get("car1")).isEqualTo(0);
        assertThat(racingProgressStatus.get("car2")).isEqualTo(2);
        assertThat(racingProgressStatus.get("car3")).isEqualTo(3);
    }

    @Test
    @DisplayName("가장 많이 이동한 자동차를 우승자로 뽑는다.")
    void getOnlyWinner() {
        LinkedHashMap<String, Integer> finalResult = new LinkedHashMap<>();
        finalResult.put("car1", 2);
        finalResult.put("car2", 4);
        finalResult.put("car3", 3);

        List<String> winners = racingCarGameService.getWinners(finalResult);

        assertThat(winners.size()).isEqualTo(1);
        assertThat(winners.get(0)).isEqualTo("car2");
    }

    @Test
    @DisplayName("가장 많이 이동한 자동차를 우승자로 뽑되, 동점자가 있다면, 동점자들 모두를 우승자로 뽑는다.")
    void getWinners() {
        LinkedHashMap<String, Integer> finalResult = new LinkedHashMap<>();
        finalResult.put("car1", 2);
        finalResult.put("car2", 4);
        finalResult.put("car3", 4);

        List<String> winners = racingCarGameService.getWinners(finalResult);

        assertThat(winners.size()).isEqualTo(2);
        assertThat(winners.get(0)).isEqualTo("car2");
        assertThat(winners.get(1)).isEqualTo("car3");
    }
}
