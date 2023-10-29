package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class RacingCarGameTest {

    @AfterEach
    void after() {
        Console.close();
    }

    @Test
    void makeCars() {
        // given
        String userInput = "aaaa,bbbb,ccc";
        RacingCarGame racingCarGame = new RacingCarGame();

        // when
        racingCarGame.makeCars(userInput);

        // then
        assertEquals(3,racingCarGame.getRacingCars().size());
        assertEquals("aaaa",racingCarGame.getRacingCars().get(0).getName());
        assertEquals("bbbb",racingCarGame.getRacingCars().get(1).getName());
        assertEquals("ccc",racingCarGame.getRacingCars().get(2).getName());

        assertEquals(0,racingCarGame.getRacingCars().get(0).getLocation());
        assertEquals(0,racingCarGame.getRacingCars().get(1).getLocation());
        assertEquals(0,racingCarGame.getRacingCars().get(2).getLocation());
    }

    @Test
    void makeCarsFail() {
        // given
        String userInput = "aaaa,bbbb,cccccc";
        RacingCarGame racingCarGame = new RacingCarGame();

        // when
        //then
        assertThatThrownBy(() -> racingCarGame.makeCars(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.CAR_NAME_LENGTH_EXCEPTION.getMessage());
    }

    @Test
    void inputTryCount() {
        //given
        RacingCarGame racingCarGame = new RacingCarGame();
        String input = "5";
        setUpInputStream(input);

        //when
        int tryCount = racingCarGame.inputTryCount();

        //then
        assertEquals(5,tryCount);
    }

    @Test
    void inputTryCountFail() {
        //given
        RacingCarGame racingCarGame = new RacingCarGame();
        String input = "a";
        setUpInputStream(input);

        //when
        //then
        assertThatThrownBy(racingCarGame::inputTryCount)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.IS_NOT_NUMBER.getMessage());
    }

    @Test
    void findMaxLocation() {
        //given
        RacingCarGame racingCarGame = new RacingCarGame();
        racingCarGame.makeCars("test1,test2,test3");

        //when
        racingCarGame.moveCars();
        List<RacingCar> racingCars = racingCarGame.getRacingCars();
        int maxLocation = Integer.MIN_VALUE;

        for (RacingCar racingCar : racingCars) {
            maxLocation = Math.max(maxLocation, racingCar.getLocation());
        }

        int findMaxLocation = racingCarGame.findMaxLocation();

        //then
        assertEquals(maxLocation,findMaxLocation);

    }

    @Test
    void findWinner() {
        //given
        RacingCarGame racingCarGame = new RacingCarGame();
        racingCarGame.makeCars("test1,test2,test3");

        //when
        racingCarGame.moveCars();
        int maxLocation = racingCarGame.findMaxLocation();
        List<RacingCar> winner = racingCarGame.findWinner(maxLocation);

        List<RacingCar> racingCars = racingCarGame.getRacingCars();

        List<RacingCar> findWinner = new ArrayList<>();

        for (RacingCar racingCar : racingCars) {
            if (maxLocation == racingCar.getLocation()) {
                findWinner.add(racingCar);
            }
        }

        assertEquals(findWinner,winner);
    }

    public void setUpInputStream(String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
    }
}
