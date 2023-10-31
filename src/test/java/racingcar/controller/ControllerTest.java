package racingcar.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ControllerTest {
    PlayerController playerController = new PlayerController();
    RacingCupController racingCupController = new RacingCupController(0, playerController);
    List<String> playerList = Arrays.asList("지환", "희종", "범조");

    @DisplayName("제로 무브 테스트")
    @Test
    void 제로_무브() {
        playerController.addPlayers(playerList);
        racingCupController.decideFinalWinner();
        assertTrue(racingCupController.getFinalWinners().equals(playerList));
    }
}
