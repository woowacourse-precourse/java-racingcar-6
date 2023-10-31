package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.view.GameMessage;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class RacingGameServiceTest {
    @DisplayName("레이싱 자동차 이름으로 레이싱 자동차 class 생성하는 테스트")
    @Test
    void constructorRacingCarWithCarNamesTest() {
        //when
        RacingGameService racingGameService = new RacingGameService();
        //given
        List<String> carsName = Arrays.asList("pobi", "namzi", "jnam", "jonhan");

        racingGameService.readyToPlay(carsName);
        List<RacingCar> racingCars = racingGameService.getRacingCars();
        //then
        assertThat(racingCars.size()).isEqualTo(4);
        assertThat(racingCars.get(0).getRacingCarName()).isEqualTo("pobi");
        assertThat(racingCars.get(1).getRacingCarName()).isEqualTo("namzi");
        assertThat(racingCars.get(2).getRacingCarName()).isEqualTo("jnam");
        assertThat(racingCars.get(3).getRacingCarName()).isEqualTo("jonhan");
    }

    @DisplayName("winner가 1명일 때 판단하는 테스트")
    @Test
    void OneWinnerTest() {
        //when
        RacingGameService racingGameService = new RacingGameService();
        //given
        List<String> carsName = Arrays.asList("pobi", "namzi", "jnam", "jonhan");
        racingGameService.readyToPlay(carsName);
        List<RacingCar> racingCars = racingGameService.getRacingCars();

        RacingCar pobi = racingCars.get(0);
        RacingCar namzi = racingCars.get(1);
        RacingCar jnam = racingCars.get(2);
        RacingCar jonhan = racingCars.get(3);

        pobi.isRacingCarMove(1);
        pobi.isRacingCarMove(2);
        pobi.isRacingCarMove(5);

        namzi.isRacingCarMove(4);
        namzi.isRacingCarMove(6);
        namzi.isRacingCarMove(9);

        jnam.isRacingCarMove(3);
        jnam.isRacingCarMove(5);
        jnam.isRacingCarMove(1);

        jonhan.isRacingCarMove(2);
        jonhan.isRacingCarMove(4);
        jonhan.isRacingCarMove(6);
        //then
        List<String> winners = racingGameService.findWinners();
        String joinString = String.join(", ", winners);
        assertThat(winners.get(0)).isEqualTo("namzi");
        assertThat(winners.size()).isEqualTo(1);
        assertThat(GameMessage.WINNER_MESSAGE.getWinnerMessage(joinString))
                .isEqualTo("최종 우승자 : namzi");
    }

    @DisplayName("winner가 1명이상 일 때 판단하는 테스트")
    @Test
    void MoreOneWinnerTest() {
        //when
        RacingGameService racingGameService = new RacingGameService();
        //given
        List<String> carsName = Arrays.asList("pobi", "namzi", "jnam", "jonhan");
        racingGameService.readyToPlay(carsName);
        List<RacingCar> racingCars = racingGameService.getRacingCars();

        RacingCar pobi = racingCars.get(0);
        RacingCar namzi = racingCars.get(1);
        RacingCar jnam = racingCars.get(2);
        RacingCar jonhan = racingCars.get(3);

        pobi.isRacingCarMove(1);
        pobi.isRacingCarMove(2);
        pobi.isRacingCarMove(5);

        namzi.isRacingCarMove(4);
        namzi.isRacingCarMove(6);
        namzi.isRacingCarMove(9);

        jnam.isRacingCarMove(7);
        jnam.isRacingCarMove(5);
        jnam.isRacingCarMove(8);

        jonhan.isRacingCarMove(2);
        jonhan.isRacingCarMove(4);
        jonhan.isRacingCarMove(6);

        //then
        List<String> winners = racingGameService.findWinners();
        String joinString = String.join(", ", winners);
        assertThat(winners.get(0)).isEqualTo("namzi");
        assertThat(winners.get(1)).isEqualTo("jnam");
        assertThat(winners.size()).isEqualTo(2);
        assertThat(GameMessage.WINNER_MESSAGE.getWinnerMessage(joinString))
                .isEqualTo("최종 우승자 : namzi, jnam");
    }
}