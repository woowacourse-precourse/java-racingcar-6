package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnerPickerTest {

    private WinnerPicker winnerPicker;
    private RacingCars racingCars;
    private List<String> carNames;
    private static final String CAR1_NAME = "pobi";
    private static final String CAR2_NAME = "woni";
    private static final String CAR3_NAME = "jun";
    private static final String CAR4_NAME = "umi";

    @BeforeEach
    void setUp() {
        winnerPicker = new WinnerPicker();
        carNames = new ArrayList<>(Arrays.asList(CAR1_NAME, CAR2_NAME, CAR3_NAME));
        racingCars = new RacingCars(carNames);

    }

    @Test
    void 우승자가_한명인_경우_pickWinner_메서드로_우승자의_이름리스트를_반환() {

        RacingCar car1 = racingCars.getRacingCars().get(0);
        RacingCar car2 = racingCars.getRacingCars().get(1);
        RacingCar car3 = racingCars.getRacingCars().get(2);

        for (int forward = 0; forward < 5; forward++) {
            car1.forward();
        }

        for (int forward = 0; forward < 7; forward++) {
            car2.forward();
        }

        for (int forward = 0; forward < 3; forward++) {
            car3.forward();
        }

        Winners winners = winnerPicker.pickWinner(racingCars);
        assertThat(winners.getWinnersName().size()).isEqualTo(1);
        assertThat(winners.getWinnersName()).contains(CAR2_NAME);
    }

    @Test
    void 우승자가_두명인_경우_pickWinner_메서드로_우승자의_이름리스트를_반환() {
        carNames.add(CAR4_NAME);
        racingCars = new RacingCars(carNames);

        RacingCar car1 = racingCars.getRacingCars().get(0);
        RacingCar car2 = racingCars.getRacingCars().get(1);
        RacingCar car3 = racingCars.getRacingCars().get(2);
        RacingCar car4 = racingCars.getRacingCars().get(3);

        for (int forward = 0; forward < 5; forward++) {
            car1.forward();
        }

        for (int forward = 0; forward < 7; forward++) {
            car2.forward();
        }

        for (int forward = 0; forward < 3; forward++) {
            car3.forward();
        }

        for (int forward = 0; forward < 7; forward++) {
            car4.forward();
        }

        Winners winners = winnerPicker.pickWinner(racingCars);

        assertThat(winners.getWinnersName().size()).isEqualTo(2);
        assertThat(winners.getWinnersName()).contains(CAR2_NAME, CAR4_NAME);
    }
}
