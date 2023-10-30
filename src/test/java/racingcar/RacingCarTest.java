package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RacingCarTest {
    @Test
    public void 자동차_이름_통과_테스트(){
        //given
        String name="haha";
        //then
        Assertions.assertEquals(true,RacingCar.is_valid_input_name(name));
    }

    @Test
    public void 자동차_이름_오류_테스트(){
        //given
        String name="hahaha";
        //then
        Assertions.assertEquals(false,RacingCar.is_valid_input_name(name));
    }
}