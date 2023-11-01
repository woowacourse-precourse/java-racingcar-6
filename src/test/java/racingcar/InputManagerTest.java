package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InputManagerTest {
    @Test
    public void 자동차_이름들_입력_테스트(){
        //given
        String input_str="pobi,woni,jun";
        //when
        List<RacingCar> expects = new ArrayList<>(Arrays.asList(
                new RacingCar("pobi"),
                new RacingCar("woni"),
                new RacingCar("jun")
        ));
        List<RacingCar> actuals = InputManager.makeRacingCars(input_str);
        //then
        Assertions.assertEquals(3,actuals.size());
        Assertions.assertEquals(expects.get(0).toString(),actuals.get(0).toString());
        Assertions.assertEquals(expects.get(1).toString(),actuals.get(1).toString());
        Assertions.assertEquals(expects.get(2).toString(),actuals.get(2).toString());
    }

    @Test
    public void 시도_횟수_입력_int_타입_변환_테스트(){
        //given
        String num_str="3";
        //then
        Assertions.assertEquals(3,InputManager.string_to_int(num_str));
    }

    @Test
    public void 시도_횟수_입력_숫자_아님_오류_테스트() {
        //given
        String num_str = "hello";
        //then
        Assertions.assertEquals(-1, InputManager.string_to_int(num_str));
    }
}