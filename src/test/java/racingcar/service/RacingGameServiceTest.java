package racingcar.service;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
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
    public void 시도_횟수_입력() {
        //given
        String input = "3";

        //when
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //then
        Assertions.assertDoesNotThrow(() -> {
            racingGameService.racingRoundInput();
        });
    }

    @Test
    public void 경주(){
        //given
        RacingCar car1 = new RacingCar();
        RacingCar car2 = new RacingCar();
        RacingCar car3 = new RacingCar();
        List<RacingCar> racingCars = List.of(car1, car2, car3);

        RacingGameService racingCarServiceSpy = Mockito.spy(racingGameService);
        //generateRandomNumber를 실행하면 4를 반환
        Mockito.doReturn(4).when(racingCarServiceSpy).generateRandomNumber();

        //when
        racingCarServiceSpy.race(racingCars);

        //then
        //4가 나오므로 1씩 증가
        assertThat(1).isEqualTo(car1.getForwardCount());
        assertThat(1).isEqualTo(car2.getForwardCount());
        assertThat(1).isEqualTo(car3.getForwardCount());

    }

    @Test
    public void 우승자_선정(){
        //given
        RacingCar racingCar1 = new RacingCar();
        racingCar1.initCar("Car1");
        racingCar1.increaseForwardCount();

        RacingCar racingCar2 = new RacingCar();
        racingCar2.initCar("Car2");
        racingCar2.increaseForwardCount();
        racingCar2.increaseForwardCount();

        RacingCar racingCar3 = new RacingCar();
        racingCar3.initCar("Car3");
        racingCar3.increaseForwardCount();
        racingCar3.increaseForwardCount();

        List<RacingCar> racingCars = new ArrayList<>();
        racingCars.add(racingCar1);
        racingCars.add(racingCar2);
        racingCars.add(racingCar3);

        //when
        List<String> winners = racingGameService.getWinner(racingCars);

        //then
        assertThat(2).isEqualTo(winners.size());
        assertThat("Car2").isEqualTo(winners.get(0));
        assertThat("Car3").isEqualTo(winners.get(1));

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