package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RacingCarGameTest {

    private RacingCarGame racingCarGame;

    @BeforeEach
    void set_up() {
        this.racingCarGame = new RacingCarGame();
    }

    @Test
    void 자동차의_전진_여부_판정_전진_가능() {
        // given
        Car car = new Car("car1");

        int roundTime = 5;

        racingCarGame.updateStatus(roundTime, car);

        // when

        // then
        assertThat(car.getStatus()).isEqualTo(1);
    }

    @Test
    void 자동차의_전진_여부_판정_전진_불가능() {
        // given
        Car car = new Car("car1");

        int roundTime = 2;

        racingCarGame.updateStatus(roundTime, car);

        // when

        // then
        assertThat(car.getStatus()).isEqualTo(0);
    }

    @Test
    void 자동차_경주_게임_최종_우승자가_1명인_경우() {
        // given
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");

        car1.updateStatus();
        car1.updateStatus();
        car2.updateStatus();
        car3.updateStatus();

        List<Car> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);

        List<String> winnerList = racingCarGame.judgeWinnerCarName(carList);

        // when


        // then
        assertThat(winnerList.size()).isEqualTo(1);
        assertThat(winnerList.get(0)).isEqualTo("car1");
    }

    @Test
    void 자동차_경주_게임_최종_우승자가_2명_이상인_경우() {
        // given
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");

        car1.updateStatus();
        car1.updateStatus();
        car2.updateStatus();
        car2.updateStatus();
        car3.updateStatus();

        List<Car> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);

        List<String> winnerList = racingCarGame.judgeWinnerCarName(carList);

        // when


        // then
        assertThat(winnerList.size()).isEqualTo(2);
        assertThat(winnerList.get(0)).isEqualTo("car1");
        assertThat(winnerList.get(1)).isEqualTo("car2");
    }
}
