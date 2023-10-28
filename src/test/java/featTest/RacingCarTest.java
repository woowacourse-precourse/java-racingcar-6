package featTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.RacingCarCreator;
import racingcar.User;

class RacingCarTest {
    List<RacingCarCreator> racingCarsList = new ArrayList<>();

    @Test
    void getRacingCarList() {
        User user = new User();
        // given
        String[] carNames = user.inputCarNames();

        // when
        for (int i = 0; i < carNames.length; i++) {
            racingCarsList.add(new RacingCarCreator(carNames[i]));
        }

        // then
        assertThat(racingCarsList.size()).isEqualTo(3);
        assertThat(racingCarsList.get(0).getCarName()).isEqualTo("A");
        assertThat(racingCarsList.get(1).getCarName()).isEqualTo("B");
        assertThat(racingCarsList.get(2).getCarName()).isEqualTo("C");
    }
}
