package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class GameServiceTest {

    @Test
    void movingForwardCheck_메서드_사용시_임의의_수가_전진을_위한_기준_값_이상인지_검사() {
        // given
        int randomNumberForMovingForward = 4;
        int randomNumberForStop = 2;

        // when && then
        assertThat(GameService.movingForwardCheck(randomNumberForMovingForward)).isTrue();
        assertThat(GameService.movingForwardCheck(randomNumberForStop)).isFalse();
    }

    @RepeatedTest(20)
    void pickRandomNumber_메서드_사용시_0부터_9까지_범위의_숫자만_뽑는지_반복_검사() {
        // given
        int randomNumber = GameService.pickRandomNumber();

        // when && then
        assertThat(randomNumber).isBetween(0, 9);
    }

    @Test
    void recordNumberOfMovingForward_메서드_사용시_isMovingForward가_true이면_전진_횟수_업데이트() {
        // given
        String input = "pobi, nini, pew";
        Map<Car, Integer> cars = CarsService.makeCars(input);

        // when
        for (Car car : cars.keySet()) {
            GameService.recordNumberOfMovingForward(cars, car, true);
        }

        // then
        for (Car car : cars.keySet()) {
            assertThat(cars.get(car)).isEqualTo(1);
        }
    }
}