package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class PlayerTest {
    Player player = new Player();

    @Test
    void 자동차_이름_저장_테스트() {
        String[] carNames = new String[]{"pobi,woni,jun"};
        player.settingPlayerCarNameStore(carNames);
        List<String> compare = Arrays.asList(carNames);

        Assertions.assertThat(player.getCarNameStore()).isEqualTo(compare);
    }

    @Test
    void 시도회수_저장_테스트() {
        int tryNumber = 5;
        player.settingPlayerTryNumber(tryNumber);

        Assertions.assertThat(player.getTryNumber()).isEqualTo(5);
    }
}
