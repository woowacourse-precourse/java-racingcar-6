package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RacingCarGameTest {

    @Test
    public void 우승자_가려내기_테스트(){
        //given
        RacingCar car1 = new RacingCar("pobi");
        car1.setCount(3);
        RacingCar car2 = new RacingCar("woni");
        car2.setCount(2);
        RacingCar car3 = new RacingCar("jun");
        car3.setCount(3);

        List<RacingCar> cars = new ArrayList<>(Arrays.asList(
                car1,car2,car3
        ));
        //when
        List<RacingCar> winner = RacingCarGame.getWinner(cars);
        //then
        Assertions.assertEquals(2,winner.size());
        Assertions.assertEquals(car1.toString(),winner.get(0).toString());
        Assertions.assertEquals(car3.toString(),winner.get(1).toString());
    }
}