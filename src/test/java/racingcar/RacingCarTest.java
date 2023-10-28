package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.validation.Validator;

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

    @Test
    void checkCarNameCount() {
        // given
        User user = new User();
        Validator validator = new Validator();
        String[] carNames = user.inputCarNames();

        // when
        for (int i = 0; i < carNames.length; i++) {
            racingCarsList.add(new RacingCarCreator(carNames[i]));
        }

        // then
        assertThrows(IllegalArgumentException.class, () -> validator.checkCarNameCount(carNames));
    }

    class User {
        public String[] inputCarNames() {
            return new String[]{"A"};
        }
    }

    class Validator {
        public void checkCarNameCount(String[] carNames) {
            if (carNames.length <= 1) {
                throw new IllegalArgumentException("경주할 수 있는 최소 자동차는 2대 이상 입니다.");
            }
        }
    }
}
