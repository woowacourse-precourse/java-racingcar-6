package racingcar.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;

class RacingCarGameTest {

    @Test
    public void 잘못된_반복횟수_입력_에러() throws Exception {

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

    @Test
    public void 문자사이_스페이스_에러() throws Exception {

        //given
        RacingCarGame game = new RacingCarGame();
        String input = "car1 ,car2\n2\n";

        //when & then
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            game.playGame();
        });
        assertEquals("각 자동차 이름의 길이가 5글자 미만으로 ,로 구분해 작성해주세요.", exception.getMessage());
    }

    @Test
    public void 빈문자_에러() throws Exception {

        //given
        RacingCarGame game = new RacingCarGame();
        String input = " ";

        //when & then
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            game.playGame();
        });
        assertEquals("각 자동차 이름의 길이가 5글자 미만으로 ,로 구분해 작성해주세요.", exception.getMessage());
    }

    @Test
    public void 동일한_이름_에러() throws Exception {

        //given
        RacingCarGame game = new RacingCarGame();
        String input = "car1 ,car1\n2\n";

        //when & then
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            game.playGame();
        });
        assertEquals("각 자동차 이름의 길이가 5글자 미만으로 ,로 구분해 작성해주세요.", exception.getMessage());
    }
}