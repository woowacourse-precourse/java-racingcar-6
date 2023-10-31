package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.view.RacingGameMessage;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class RacingGameTest {
    @DisplayName("레이싱 자동차 이름으로 레이싱 자동차 class 생성하는 테스트")
    @Test
    void constructorRacingCarWithCarNamesTest() {
        //when
        RacingGame racingGame = new RacingGame();
        //given
        String carsName = "pobi,namzi,jnam,jonhan";

        racingGame.readyToCars(carsName);
        List<RacingCar> racingCars = racingGame.getRacingCars();
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
        RacingGame racingGame = new RacingGame();
        //given
        String carsName = "pobi,namzi,jnam,jonhan";
        racingGame.readyToCars(carsName);
        List<RacingCar> racingCars = racingGame.getRacingCars();

        RacingCar pobi = racingCars.get(0);
        RacingCar namzi = racingCars.get(1);
        RacingCar jnam = racingCars.get(2);
        RacingCar jonhan = racingCars.get(3);

        pobi.move(1);
        pobi.move(2);
        pobi.move(5);

        namzi.move(4);
        namzi.move(6);
        namzi.move(9);

        jnam.move(3);
        jnam.move(5);
        jnam.move(1);

        jonhan.move(2);
        jonhan.move(4);
        jonhan.move(6);
        //then
        List<String> winners = racingGame.findWinners();
        String joinString = racingGame.getWinners();
        assertThat(winners.get(0)).isEqualTo("namzi");
        assertThat(winners.size()).isEqualTo(1);
        assertThat(RacingGameMessage.WINNER_MESSAGE.getWinnerMessage(joinString))
                .isEqualTo("최종 우승자 : namzi");
    }

    @DisplayName("winner가 1명이상 일 때 판단하는 테스트")
    @Test
    void MoreOneWinnerTest() {
        //when
        RacingGame racingGame = new RacingGame();
        //given
        String carsName = "pobi,namzi,jnam,jonhan";
        racingGame.readyToCars(carsName);
        List<RacingCar> racingCars = racingGame.getRacingCars();

        RacingCar pobi = racingCars.get(0);
        RacingCar namzi = racingCars.get(1);
        RacingCar jnam = racingCars.get(2);
        RacingCar jonhan = racingCars.get(3);

        pobi.move(1);
        pobi.move(2);
        pobi.move(5);

        namzi.move(4);
        namzi.move(6);
        namzi.move(9);

        jnam.move(7);
        jnam.move(5);
        jnam.move(8);

        jonhan.move(2);
        jonhan.move(4);
        jonhan.move(6);

        //then
        List<String> winners = racingGame.findWinners();
        String joinString = racingGame.getWinners();
        assertThat(winners.get(0)).isEqualTo("namzi");
        assertThat(winners.get(1)).isEqualTo("jnam");
        assertThat(winners.size()).isEqualTo(2);
        assertThat(RacingGameMessage.WINNER_MESSAGE.getWinnerMessage(joinString))
                .isEqualTo("최종 우승자 : namzi, jnam");
    }
}