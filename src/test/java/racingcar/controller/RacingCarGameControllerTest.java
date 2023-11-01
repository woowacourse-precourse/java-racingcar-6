package racingcar.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Player;
import racingcar.view.RacingCarGameView;

class RacingCarGameControllerTest {

    private RacingCarGameController racingCarGameController;
    private List<String> playerNameList;
    private ByteArrayOutputStream outputStream;

    protected InputStream createInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    private String getOutput() {
        return outputStream.toString();
    }

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        RacingCarGameView racingCarGameView = new RacingCarGameView();
        racingCarGameController = new RacingCarGameController(racingCarGameView);

        playerNameList = new ArrayList<>();
        playerNameList.add("a");
        playerNameList.add("b");
        playerNameList.add("c");
    }

    @AfterEach
    void coleTest() {
        Console.close();
        System.setOut(System.out);
    }

    @Test
    void run() {
        System.setIn(createInput("a,b,c\n0"));

        racingCarGameController.run();
        assertEquals("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n"
                + "시도할 회수는 몇회인가요?\n\n"
                + "실행 결과\n"
                + "최종 우승자 : a, b, c\n", outputStream.toString());
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