package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class RacingTest {
    @Test
    public void start_횟수_곱하기_자동차수_만큼의_경주기록_생성() throws Exception {
        //given
        List<String> carNames = List.of("car1", "car2", "car3");
        RacingInfo racingInfo = new RacingInfo(carNames, 5);
        Racing racing = Racing.create(racingInfo);
        int numOfCar = 3;
        int turn = 5;

        //when
        racing.start();

        //then
        Assertions.assertThat(racing.getDistanceRecord().size())
                .isEqualTo(turn * numOfCar);
    }

    @Test
    public void start_자동차수_이하의_우승자_생성() throws Exception {
        //given
        List<String> carNames = List.of("car1", "car2", "car3");
        RacingInfo racingInfo = new RacingInfo(carNames, 5);
        Racing racing = Racing.create(racingInfo);
        int numOfCar = 3;

        //when
        racing.start();

        //then
        Assertions.assertThat(racing.getWinners().size())
                .isLessThanOrEqualTo(numOfCar);
    }
}