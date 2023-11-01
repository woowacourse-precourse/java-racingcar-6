package racingcar;

import controller.GameController;
import model.CarDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import camp.nextstep.edu.missionutils.Console;

import java.io.ByteArrayInputStream;
import java.util.LinkedList;
import java.util.List;


class GameControllerTest {

    private GameController gameController;
    private Console console;

    @BeforeEach
    void setUp() {
        String input = "car1,car2,car3\n"; // 사용자 입력을 시뮬레이트하는 문자열
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        gameController = new GameController();
    }

    @Test
    void givenValidInputWhenInitGameThenCarListIsCreated() {
        when(console.readLine()).thenReturn("car1,car2,car3");
        gameController.initGame();
        assertEquals(3, gameController.carList.size());
    }

    @Test
    void givenInvalidInputWhenInitGameThenThrowsIllegalArgumentException() {
        when(console.readLine()).thenReturn("car1,car2,");
        IllegalArgumentException exception = org.junit.jupiter.api.Assertions.assertThrows(
                IllegalArgumentException.class,
                gameController::initGame
        );
        assertEquals("Invalid input message", exception.getMessage());
    }

    @Test
    void givenPlayNumberWhenPlayGameThenCarListIsUpdated() {
        when(console.readLine()).thenReturn("car1,car2,car3");
        gameController.initGame();
        when(console.readLine()).thenReturn("1");
        gameController.playGame();
    }

    @Test
    void givenMaxScoreWhenFindMaxScoreThenCorrectMaxScoreIsFound() {
        List<CarDto> carList = new LinkedList<>();
        carList.add(new CarDto("car1", 3)); // 스코어 3
        carList.add(new CarDto("car2", 5)); // 스코어 5
        carList.add(new CarDto("car3", 2)); // 스코어 2

        gameController.setCarList(carList);
        gameController.findMaxScore();

        assertEquals(5, gameController.getMaxScore());
    }

    @Test
    void givenCarListAndMaxScoreWhenFindWinnerThenCorrectWinnersAreFound() {
        List<CarDto> carList = new LinkedList<>();
        carList.add(new CarDto("car1", 5)); // 스코어 5
        carList.add(new CarDto("car2", 5)); // 스코어 5
        carList.add(new CarDto("car3", 3)); // 스코어 3

        gameController.setCarList(carList);
        gameController.setMaxScore(5);
        gameController.findWinner();

        List<CarDto> winners = gameController.getWinnerList();
        assertEquals(2, winners.size());
        assertEquals("car1", winners.get(0).getName());
        assertEquals("car2", winners.get(1).getName());

    }
}
