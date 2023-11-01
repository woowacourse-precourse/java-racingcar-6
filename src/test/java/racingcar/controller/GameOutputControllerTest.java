package racingcar.controller;

import static java.lang.String.format;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static racingcar.common.Constants.ANNOUNCEMENT_OF_WINNER;
import static racingcar.common.Constants.NEW_LINE;
import static racingcar.common.Constants.RESULT_MESSAGE;

import java.util.Map;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.IOTest;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Game;

class GameOutputControllerTest extends IOTest {

    private GameOutputController outputController;
    Game game;
    Cars cars;

    @BeforeEach
    void setUp() {
        cars = new Cars();
        cars.settingNames("seori,snow,joy");

        game = new Game(cars);
        game.settingChance("1");

        outputController = new GameOutputController();
        outputController.readyForGame(game);

        systemOut();
    }

    @AfterEach
    void after() {
        clean();
    }

    @Test
    void startGame_메서드로_게임_진행() {
        //given, when
        Map<String, Integer> beforeMap = game.getGameResult();
        outputController.startGame();
        Map<String, Integer> afterMap = game.getGameResult();

        //then
        assertThat(getOutput()).contains(NEW_LINE, RESULT_MESSAGE);

        assertThat(beforeMap).isNull();

        assertTrue(afterMap.containsKey("seori"));
        assertTrue(afterMap.containsKey("snow"));
        assertTrue(afterMap.containsKey("joy"));
        assertFalse(afterMap.containsKey("pobi"));
    }

    @Test
    void printWinner_메서드로_최종_우승자_출력() {
        //given
        for(Car car : cars.getCarList()) {
            if(car.getName().equals("seori")) {
                car.move(4);
            }
        }

        //when
        outputController.printWinner();

        //then
        String result = format(ANNOUNCEMENT_OF_WINNER, "seori");
        assertThat(getOutput()).isEqualTo(result);
    }

}