package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.RaceRule;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingServiceTest {

    RacingService racingService;

    @BeforeEach
    public void setUp() {
        RaceRule raceRule = () -> true;
        racingService = new RacingService(raceRule);
        List<String> nameList = Arrays.asList("pobi", "woni", "jun");
        racingService.generateCar(nameList);
    }

    @Test
    @DisplayName("이동 결과를 정상적으로 반환한다.")
    void playRace() {
        String tryInput = "2";
        List<String> moveResult = racingService.playRace(tryInput);

        assertThat(moveResult.get(0)).isEqualTo("pobi : -\nwoni : -\njun : -");
        assertThat(moveResult.get(1)).isEqualTo("pobi : --\nwoni : --\njun : --");
        assertThatThrownBy(() -> moveResult.get(2))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    @DisplayName("우승자를 반환한다.")
    void getWinner() {
        String tryInput = "2";
        List<String> moveResult = racingService.playRace(tryInput);

        String winner = racingService.getWinner();
        assertThat(winner).isEqualTo("pobi, woni, jun");
    }
}