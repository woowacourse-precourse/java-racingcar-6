package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class RacingTest {
    static final List<String> SAMPLE_CARS = List.of("car1", "car2", "car3");
    static final int TURN = 5;
    static final int NUMBER_OF_SAMPLE_CARS = 3;
    @Test
    public void start_횟수_곱하기_자동차수_만큼의_경주기록_생성() throws Exception {
        //given
        RacingInfo racingInfo = new RacingInfo(SAMPLE_CARS, TURN);
        Racing racing = Racing.create(racingInfo);

        //when
        racing.start();

        //then
        Assertions.assertThat(racing.getDistanceRecord().size())
                .isEqualTo(TURN * NUMBER_OF_SAMPLE_CARS);
    }

    @Test
    public void start_자동차수_이하의_우승자_생성() throws Exception {
        //given
        RacingInfo racingInfo = new RacingInfo(SAMPLE_CARS, TURN);
        Racing racing = Racing.create(racingInfo);

        //when
        racing.start();

        //then
        Assertions.assertThat(racing.getWinners().size())
                .isLessThanOrEqualTo(NUMBER_OF_SAMPLE_CARS);
    }
}