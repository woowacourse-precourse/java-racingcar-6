package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameServiceTest {

    @Test
    @DisplayName("게임 횟수 입력")
    void 게임_횟수_입력(){

        GameService gameService = new GameService();
        int round = gameService.initGameRound("3");

        assertEquals(3,round);
    }
}
