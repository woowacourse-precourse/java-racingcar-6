package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class RacingJudgeTest {

    @Test
    public void race_judge_메서드로_순위() throws Exception{
        //given
        Car c1 = new Car("TestCar1");
        Car c2 = new Car("TestCar2");
        List<Car> cars = Arrays.asList(c1,c2);
        int times = 10;

        RacingUtil.raceStart(cars, times);
        //when
        List<String> winner = RacingJudge.raceJudge(cars);
        //then
        assertThat(winner.size()).isPositive();
    }
}