package racingcar.service;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingCar;

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
        assertThat(3).isEqualTo(racingCars.size());
        assertThat("Car1").isEqualTo(racingCars.get(0).getCarName());
        assertThat("Car2").isEqualTo(racingCars.get(1).getCarName());
        assertThat("Car3").isEqualTo(racingCars.get(2).getCarName());
    }

    @Test
    void 랜덤_수_생성() {
        //given
        int randNumber;

        //when
        randNumber = racingGameService.generateRandomNumber();

        //then
        assertThat(randNumber).isLessThanOrEqualTo(9);
        assertThat(randNumber).isGreaterThanOrEqualTo(0);
    }
}