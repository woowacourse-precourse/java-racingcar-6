package racingcar.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Player;
import racingcar.view.RacingCarGameView;

class RacingCarGameControllerTest {

    private RacingCarGameController racingCarGameController;
    private List<String> playerNameList;

    @BeforeEach
    void setUp() {
        RacingCarGameView racingCarGameView = new RacingCarGameView();
        racingCarGameController = new RacingCarGameController(racingCarGameView);

        playerNameList = new ArrayList<>();
        playerNameList.add("a");
        playerNameList.add("b");
        playerNameList.add("c");
    }

    @Test
    void run() {
    }

    @Test
    void generatePlayer() {
        List<Player> playerList = racingCarGameController.generatePlayer(playerNameList);

        assertEquals(3, playerList.size());

        for (int i = 0; i < playerNameList.size(); i++) {
            assertEquals(playerNameList.get(i), playerList.get(i).getName());
        }
    }

    @Test
    void moveOrNot() {
        List<Player> playerList = racingCarGameController.generatePlayer(playerNameList);

        racingCarGameController.moveOrNot(playerList.get(0), 0);
        racingCarGameController.moveOrNot(playerList.get(1), 1);
        racingCarGameController.moveOrNot(playerList.get(2), 5);

        assertEquals(0, playerList.get(0).getLocation());
        assertEquals(0, playerList.get(1).getLocation());
        assertEquals(1, playerList.get(2).getLocation());
    }

    @Test
    void judgeGame() {
        List<Player> playerList = new ArrayList<>();
        playerList.add(new Player("a", 0));
        playerList.add(new Player("b", 1));

        List<Player> winner = racingCarGameController.judgeGame(playerList);

        assertEquals("b", winner.get(0).getName());
    }
}