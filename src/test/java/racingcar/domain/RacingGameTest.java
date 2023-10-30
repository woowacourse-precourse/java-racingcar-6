package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RacingGameTest {

    public static final int TEST_REPEAT = 5;
    private RacingGame racingGame;

    @BeforeEach
    public void init() {
        ArrayList<Car> carList = new ArrayList<>();
        carList.add(new Car(new TestNumberGenerator(5)));
        carList.add(new Car(new TestNumberGenerator(3)));
        carList.add(new Car(new TestNumberGenerator(6)));
        racingGame = new RacingGame(carList, TEST_REPEAT);
    }

    @Test
    public void 레이싱을_한다() {

        racingGame.doRace();

        assertThat(racingGame.getStatus()).filteredOn(car -> car.getLocation() != 0).hasSize(2);
    }

    @Test
    public void 게임이_끝나면_True를_반환() {

        for (int i = 0; i < TEST_REPEAT; i++) {
            racingGame.doRace();
        }

        assertThat(racingGame.isEnd()).isTrue();
    }

}
