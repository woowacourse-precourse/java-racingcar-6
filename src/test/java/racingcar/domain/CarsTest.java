package racingcar.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    void 중복_체크(){
        //given
        String input = "유정,유정,유정님";

        //when,then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Cars(input);
        });
    }
}