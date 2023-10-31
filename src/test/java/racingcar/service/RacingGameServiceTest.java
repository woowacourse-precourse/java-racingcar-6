package racingcar.service;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingCar;
import racingcar.view.SystemMessage;

class RacingGameServiceTest {

    private RacingGameService racingGameService;

    @BeforeEach
    public void setUp() {
        racingGameService = new RacingGameService();
    }

    @Test
    public void 자동차_이름_3개_입력() {
        //given
        String input = "Car1,Car2,Car3";

        //when
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        List<RacingCar> racingCars = racingGameService.carNameInput();


        //then
        assertEquals(3, racingCars.size());
        assertEquals("Car1", racingCars.get(0).getCarName());
        assertEquals("Car2", racingCars.get(1).getCarName());
        assertEquals("Car3", racingCars.get(2).getCarName());
    }

    @Test
    void 경주() {
    }

    @Test
    void getWinner() {
    }

    @Test
    void getMaxForwardCount() {
    }

    @Test
    void generateRandomNumber() {


    }
}