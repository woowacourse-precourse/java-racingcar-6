package racingcar;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {

    @Test
    void findWinners_하나의_우승자() {
        List<String> carStatus = Arrays.asList("----", "--", "---", "---");
        List<String> carNames = Arrays.asList("car1", "car2", "car3", "car4");

        List<String> winners = RacingCarGame.findWinners(carStatus, carNames);

        assertThat(winners).containsExactly("car1");
    }

    @Test
    void findWinners_여러_우승자() {
        List<String> carStatus = Arrays.asList("----", "----", "----", "---");
        List<String> carNames = Arrays.asList("car1", "car2", "car3", "car4");

        List<String> winners = RacingCarGame.findWinners(carStatus, carNames);

        assertThat(winners).containsExactly("car1", "car2", "car3");
    }

}
