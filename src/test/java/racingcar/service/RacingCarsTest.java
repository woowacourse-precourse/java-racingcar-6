package racingcar.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.model.RacingCars;

import java.util.ArrayList;
import java.util.List;

public class RacingCarsTest {
    private final String racingCarNames = "pobi,woni,jun";

    @Test
    void RacingCars_객체_만들기() {
        List<String> statusList = new ArrayList<>();

        String status1 = "pobi : ";
        String status2 = "woni : ";
        String status3 = "jun : ";

        statusList.add(status1);
        statusList.add(status2);
        statusList.add(status3);

        RacingCars racingCars = new RacingCars(racingCarNames);
        Assertions.assertThat(racingCars.getRacingCarsStatus()).isEqualTo(statusList);
    }

    @Test
    void 최대_moveCount_도출하기() {
        RacingCars racingCars = new RacingCars(racingCarNames);
        List<Integer> randomNumbers = new ArrayList<>();
        randomNumbers.add(5);
        randomNumbers.add(1);
        randomNumbers.add(1);

        racingCars.play(randomNumbers);

        randomNumbers.clear();
        randomNumbers.add(5);
        randomNumbers.add(1);
        randomNumbers.add(1);

        racingCars.play(randomNumbers);

        Assertions.assertThat(racingCars.getMaxMoveCount()).isEqualTo(2);
    }

    @Test
    void 단일_우승자_결과_도출하기() {
        RacingCars racingCars = new RacingCars(racingCarNames);
        List<Integer> randomNumbers = new ArrayList<>();
        randomNumbers.add(5);
        randomNumbers.add(1);
        randomNumbers.add(1);

        racingCars.play(randomNumbers);

        randomNumbers.clear();
        randomNumbers.add(5);
        randomNumbers.add(1);
        randomNumbers.add(1);

        racingCars.play(randomNumbers);

        List<String> winners = new ArrayList<>();
        winners.add("pobi");

        Assertions.assertThat(racingCars.getWinners()).isEqualTo(winners);
    }

    @Test
    void 공동_우승자_결과_도출하기() {
        RacingCars racingCars = new RacingCars(racingCarNames);
        List<Integer> randomNumbers = new ArrayList<>();
        randomNumbers.add(5);
        randomNumbers.add(5);
        randomNumbers.add(1);

        racingCars.play(randomNumbers);

        randomNumbers.clear();
        randomNumbers.add(5);
        randomNumbers.add(5);
        randomNumbers.add(1);

        racingCars.play(randomNumbers);

        List<String> winners = new ArrayList<>();
        winners.add("pobi");
        winners.add("woni");

        Assertions.assertThat(racingCars.getWinners()).isEqualTo(winners);
    }
}
