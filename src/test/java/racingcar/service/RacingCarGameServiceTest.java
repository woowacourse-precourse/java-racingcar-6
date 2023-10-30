package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.LinkedHashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarGameServiceTest {

    private RacingCarGameService racingCarGameService;

    @BeforeEach
    void setUp() {
        racingCarGameService = new RacingCarGameService();
    }

    @ParameterizedTest(name = "[테스트 케이스 {index}] 랜덤 숫자 = {0}, 전진 결과 = {1}")
    @CsvSource({"3,false", "4,true", "5,true"})
    @DisplayName("4이상은 전진하고, 3이하는 정지상태를 유지한다.")
    public void should_MoveForward_When_FourOrMore(int randomNumber, boolean expected) {
        boolean actual = racingCarGameService.isMoveForward(randomNumber);

        assertThat(actual).isEqualTo(expected);
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
