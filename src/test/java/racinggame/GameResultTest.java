package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.GameResult;
import racingcar.RacingCar;
import racingcar.RacingGame;
import racingcar.enums.GameStatus;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 게임 결과에 대한 테스트
 */
public class GameResultTest {

    @Test
    @DisplayName("게임 결과 단독 우승 성공")
    void game_result_single_winner_success() {
        RacingCar winner = new RacingCar("c", 3);
        List<RacingCar> racingCars = List.of(
                new RacingCar("a", 1),
                new RacingCar("b", 2),
                winner
        );

        RacingGame game = new RacingGame(GameStatus.PLAYING);
        game.setParticipants(racingCars);
        GameResult gameResult = game.chooseWinners();

        assertEquals(1, gameResult.getWinners().size());
        assertEquals(winner.getName(), gameResult.getWinners().get(0).getName());
    }

    @Test
    @DisplayName("게임 결과 공동 우승 성공")
    void game_result_multiple_winners_success() {
        RacingCar winnerC = new RacingCar("c", 3);
        RacingCar winnerD = new RacingCar("d", 3);
        List<RacingCar> racingCars = List.of(
                new RacingCar("a", 1),
                new RacingCar("b", 2),
                winnerC,
                winnerD
        );

        RacingGame game = new RacingGame(GameStatus.PLAYING);
        game.setParticipants(racingCars);
        GameResult gameResult = game.chooseWinners();

        assertEquals(2, gameResult.getWinners().size());
        assertEquals(winnerC.getName(), gameResult.getWinners().get(0).getName());
        assertEquals(winnerD.getName(), gameResult.getWinners().get(1).getName());
    }

    @Test
    @DisplayName("누구도 전진하지 못한 경우 전부 우승 성공")
    void game_result_all_winners_success() {
        List<RacingCar> racingCars = List.of(
                new RacingCar("a", 0),
                new RacingCar("b", 0),
                new RacingCar("c", 0),
                new RacingCar("d", 0)
        );

        RacingGame game = new RacingGame(GameStatus.PLAYING);
        game.setParticipants(racingCars);
        GameResult gameResult = game.chooseWinners();

        assertEquals(racingCars.size(), gameResult.getWinners().size());
        for (int i = 0; i < gameResult.getWinners().size(); i++) {
            assertEquals(racingCars.get(i).getName(), gameResult.getWinners().get(i).getName());
        }
    }

}
