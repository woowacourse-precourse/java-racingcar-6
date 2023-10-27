package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class RacingCarListTest {
    TestUser testUser = new TestUser();
    List<RacingCarCreator> racingCarsList = new ArrayList<>();

    class TestUser {
        public String[] inputCarNames() {
            return new String[] { "A", "B", "C" };
        }
    }
    @Test
    void getRacingCarList() {
        // given
        String[] carNames = testUser.inputCarNames();

        RacingCarCreator racingCarCreator1 = new RacingCarCreator(carNames[0]);
        RacingCarCreator racingCarCreator2 = new RacingCarCreator(carNames[1]);
        RacingCarCreator racingCarCreator3 = new RacingCarCreator(carNames[2]);

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