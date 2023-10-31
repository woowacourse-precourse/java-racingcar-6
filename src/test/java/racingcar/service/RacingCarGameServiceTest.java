package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.RandomNumberGenerator;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
        List<String> carNames = List.of("carName1", "carName2", "carName3");
        LinkedHashMap<String, Integer> racingProgressStatus = new LinkedHashMap<>(Map.of("carName1", 0, "carName2", 1, "carName3", 2));

        racingCarGameService.playSingleGame(randomNumberGenerator, carNames, racingProgressStatus);

        assertThat(racingProgressStatus.get("carName1")).isEqualTo(0);
        assertThat(racingProgressStatus.get("carName2")).isEqualTo(2);
        assertThat(racingProgressStatus.get("carName3")).isEqualTo(3);
    }

    @Test
    @DisplayName("가장 많이 이동한 자동차를 우승자로 뽑는다.")
    void getOnlyWinner() {
        LinkedHashMap<String, Integer> finalResult = new LinkedHashMap<>();
        finalResult.put("park", 2);
        finalResult.put("yong", 4);
        finalResult.put("hyeon", 3);

        List<String> winners = racingCarGameService.getWinners(finalResult);

        assertThat(winners.size()).isEqualTo(1);
        assertThat(winners.get(0)).isEqualTo("yong");
    }

    @Test
    @DisplayName("가장 많이 이동한 자동차를 우승자로 뽑되, 동점자가 있다면, 동점자들 모두를 우승자로 뽑는다.")
    void getWinners() {
        LinkedHashMap<String, Integer> finalResult = new LinkedHashMap<>();
        finalResult.put("park", 2);
        finalResult.put("yong", 4);
        finalResult.put("hyeon", 4);

        List<String> winners = racingCarGameService.getWinners(finalResult);

        assertThat(winners.size()).isEqualTo(2);
        assertThat(winners.get(0)).isEqualTo("yong");
        assertThat(winners.get(1)).isEqualTo("hyeon");
    }
}
