package racingcar.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RacingCarGameServiceTest {

    @Test
    void 차_리스트를_넘겨주면_최대이동거리를_구할수있다(){
        //given
        RacingCarGameService racingCarGameService = new RacingCarGameService();

        List<Car> list = new ArrayList<>();
        Car car1 = new Car("pobi");
        Car car2 = new Car("dobi");
        Car car3 = new Car("cobi");

        car1.move(4);
        car1.move(4);
        car2.move(4);

        list.add(car1);
        list.add(car2);
        list.add(car3);
        //when
        int maxMoveNumber = racingCarGameService.getMaxMoveNumber(list);
        //then
        Assertions.assertThat(maxMoveNumber).isEqualTo(2);
    }

    @Test
    void 차_리스트와_최대이동거리를_알면_우승자_리스트를_알수있다(){
        //given
        RacingCarGameService racingCarGameService = new RacingCarGameService();

        List<Car> list = new ArrayList<>();
        Car car1 = new Car("pobi");
        Car car2 = new Car("dobi");
        Car car3 = new Car("cobi");

        car1.move(4);
        car1.move(4);
        car2.move(4);

        list.add(car1);
        list.add(car2);
        list.add(car3);
        //when
        int maxMoveNumber = racingCarGameService.getMaxMoveNumber(list);
        List<String> winnerNames = racingCarGameService.getWinnerNames(list, maxMoveNumber);
        //then
        Assertions.assertThat(winnerNames).contains(car1.getName());
    }

}