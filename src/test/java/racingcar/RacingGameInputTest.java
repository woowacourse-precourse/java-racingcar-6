package racingcar;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RacingGameInputTest {

    @AfterEach
    public void close() {
        Console.close();
    }

    @Test
    @DisplayName("자동차 이름을 입력한다. 이름들은 쉼표로 구분되어 리스트에 담긴다")
    public void testCarNamesInput() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("테스트,자동차".getBytes());
        System.setIn(inputStream);

        RacingGameView racingGameView = new RacingGameView();
        List<String> input = racingGameView.inputCarNames();

        assertEquals("테스트", input.get(0));
        assertEquals("자동차", input.get(1));
    }

    @Test
    @DisplayName("게임을 몇 라운드 동안 진행할지 입력한다. 입력값은 숫자로 변환된다")
    public void testGameRoundsInput() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("10".getBytes());
        System.setIn(inputStream);

        RacingGameView racingGameView = new RacingGameView();
        int input = racingGameView.inputGameRounds();

        assertEquals(10, input);
    }

}
