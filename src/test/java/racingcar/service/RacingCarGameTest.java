package racingcar.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;

class RacingCarGameTest{

    @Test
    public void 반복횟수_입력_테스트() throws Exception {

        //given
        RacingCarGame game = new RacingCarGame();
        String input = "car1,car2\na\n";

        //when & then
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            game.playGame();
        });
        assertEquals("숫자를 입력해주세요.", exception.getMessage());
    }


}