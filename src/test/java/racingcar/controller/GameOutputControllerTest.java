package racingcar.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;
import racingcar.domain.Game;

class GameOutputControllerTest {

    static GameOutputController outputController;

    @BeforeAll
    static void setUp() {
        Cars cars = new Cars();
        Game game = new Game(cars);
        outputController = new GameOutputController();
        outputController.readyForGame(game);
    }

    @Test
    void startGame_메서드로_게임_진행() {
        //startGame 호출하면 게임이 진행되어야 한다.
        //given


        //when
        outputController.startGame();
    }

    @Test
    void printWinner_메서드로_최종_우승자_출력() {
        //printWinner를 호출하면 최종 우승자가 출력되어야 한다.
        //given

        //when

        //then

    }

}