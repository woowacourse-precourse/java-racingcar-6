package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.TryCount;

class RacingGameTest {

    private RacingGame racingGame = new RacingGame();

    @Test
    void 쉼표를_기준으로_자동차의_이름을_입력받기() {
        List<Car> cars = racingGame.generateCar("povi,woni,minu");
        assertThat(cars.size()).isEqualTo(3);
    }

    @Test
    void 주어진_횟수_동안_자동차가_전진또는멈추게한다() {
        List<Car> cars = racingGame.generateCar("povi,woni,minu");
        racingGame.moveForCount(5);
    }

}