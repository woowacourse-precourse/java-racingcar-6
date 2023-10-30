package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RacingCarGameTest {
    @Test
    public void 사용자_입력_테스트(){
        //given
        String input_str="pobi,woni,jun";
        //when
        List<RacingCar> expects = new ArrayList<>(Arrays.asList(
                new RacingCar("pobi"),
                new RacingCar("woni"),
                new RacingCar("jun")
        ));
        List<RacingCar> actuals = RacingCarGame.makeRacingCars(input_str);
        //then
        Assertions.assertEquals(3,actuals.size());
        Assertions.assertEquals(expects.get(0).toString(),actuals.get(0).toString());
        Assertions.assertEquals(expects.get(1).toString(),actuals.get(1).toString());
        Assertions.assertEquals(expects.get(2).toString(),actuals.get(2).toString());
    }


}