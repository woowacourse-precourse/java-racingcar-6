package racingcar.service;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Game;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;

public class GameServiceTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    GameService gameService;

    Game game;

    RacingCars racingCars;

    @BeforeEach
    void setUp() {
        this.gameService = new GameService();

        List<RacingCar> racingCarList = Arrays.asList(
            new RacingCar("pobi"),
            new RacingCar("woni"),
            new RacingCar("jun")
        );
        this.racingCars = new RacingCars(racingCarList);
        this.game = new Game(racingCars, 5);
    }

    @DisplayName("게임 객체를 생성한다. - 성공")
    @Test
    void createGameTest() {
        // given
        List<String> carNames = Arrays.asList("pobi", "woni", "jun");
        int totalAttempts = 5;

        // when
        Game game = gameService.createGame(carNames, totalAttempts);

        // then
        assertAll(
            () -> assertNotNull(game),
            () -> assertEquals(game.getRacingCarList().size(), 3)
        );
    }

    @DisplayName("게임 플레이시 시도 횟수가 증가한다. - 성공")
    @Test
    void playSingleRoundTest() {
        // when
        gameService.playSingleRound(game);

        // then
        assertEquals(1, game.getAttempts());
    }

    @DisplayName("자동차가 특정 조건에 의해서 이동한다. - 성공")
    @Test
    void moveCarsTest() {
        assertRandomNumberInRangeTest(
            () -> {
                // when
                gameService.playSingleRound(game);

                // then
                assertAll(
                    () -> assertEquals(game.getRacingCarList().get(0).getPosition(), 1),
                    () -> assertEquals(game.getRacingCarList().get(1).getPosition(), 0),
                    () -> assertEquals(game.getRacingCarList().get(2).getPosition(), 1)
                );
            },
            MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @DisplayName("시도 횟수가 끝나면 게임이 끝난다. - 성공")
    @Test
    void gameEndTest() {
        // given
        List<String> carNames = Arrays.asList("pobi", "woni", "jun");
        int totalAttempts = 1;

        // when
        Game game = gameService.createGame(carNames, totalAttempts);
        gameService.playSingleRound(game);

        // then
        assertAll(
            () -> assertEquals(game.getAttempts(), 1),
            () -> assertTrue(game.isGameEnd())
        );
    }

    @DisplayName("승리자가 1명일 때 승리자를 찾는다. - 성공")
    @Test
    void findWinnerIfOneTest() {
        assertRandomNumberInRangeTest(
            () -> {
                // when
                gameService.playSingleRound(game);
                List<String> winners = gameService.findWinners(game);

                // then
                assertThat(winners).isEqualTo(List.of("pobi"));
            },
            MOVING_FORWARD, STOP, STOP
        );
    }

    @DisplayName("승리자가 2명 이상일 때 승리자를 찾는다. - 성공")
    @Test
    void findWinnerIfMoreThanTwoTest() {
        assertRandomNumberInRangeTest(
            () -> {
                // when
                gameService.playSingleRound(game);
                List<String> winners = gameService.findWinners(game);

                // then
                assertThat(winners).isEqualTo(List.of("pobi", "woni"));
            },
            MOVING_FORWARD, MOVING_FORWARD, STOP
        );
    }

}
