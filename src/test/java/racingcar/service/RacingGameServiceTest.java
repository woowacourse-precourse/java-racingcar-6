package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Cars;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RacingGameServiceTest {

    public static RacingGameService racingGameService;

    @BeforeEach
    void setUp() {
        racingGameService = new RacingGameService();
    }

    @Test
    void createRacingCars() {
        //given
        String[] carNamesList = {"pobi", "crong", "honux"};
        //when
        Cars cars = racingGameService.createRacingCars(carNamesList);
        //then
        assertEquals(3, cars.getCarsLength());
    }

    @Test
    void getWinner() {
        //given
        String[] carNamesList = {"pobi", "crong", "honux"};
        Cars cars = racingGameService.createRacingCars(carNamesList);
        //when
        cars.getCars().get(0).setPosition(4);
        List<String> winner = racingGameService.getWinner(cars);
        //then
        assertEquals("pobi",String.join(", ",winner));
    }

    @Test
    void randomNumber() {
        //given
        String[] carNamesList = {"pobi", "crong", "honux"};
        Cars cars = racingGameService.createRacingCars(carNamesList);
        //when
        racingGameService.randomNumber(cars.getCars().get(0));
        //then
        assertTrue(cars.getCars().get(0).getPosition() >= 0);
    }

    @Test
    void getMaxPosition() {
        //given
        String[] carNamesList = {"pobi", "crong", "honux"};
        Cars cars = racingGameService.createRacingCars(carNamesList);
        //when
        cars.getCars().get(0).setPosition(4);
        cars.getCars().get(1).setPosition(3);
        cars.getCars().get(2).setPosition(2);
        Integer maxPosition = racingGameService.getMaxPosition(cars);
        //then
        assertEquals(4, maxPosition);
    }
}