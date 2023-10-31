package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import game.GameStatus;
import game.RacingGame;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class GameTest {

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @Test
    void 게임시작시_READY상태() {
        RacingGame racingGame = new RacingGame();
        assertThat(racingGame).hasFieldOrPropertyWithValue("status", GameStatus.READY);
    }

    @Test
    void 게임상태가_READY일시_사용자입력처리() {
        RacingGame racingGame = new RacingGame();
        System.setIn(createUserInput("pobi,woni,jun\n5"));
        racingGame.run();
        assertThat(racingGame).hasFieldOrPropertyWithValue("status", GameStatus.PROCEEDING)
                .hasNoNullFieldsOrProperties();
    }

    InputStream createUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}
