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
    private List<RacingCar> carList;
    private static final String CAR1_NAME = "pobi";
    private static final String CAR2_NAME = "woni";
    private static final String CAR3_NAME = "jun";
    private static final String CAR4_NAME = "umi";

    @BeforeEach
    void setUp() {
        winnerPicker = new WinnerPicker();
        RacingCar car1 = new RacingCar(CAR1_NAME);
        RacingCar car2 = new RacingCar(CAR2_NAME);
        RacingCar car3 = new RacingCar(CAR3_NAME);

        for (int forward = 0; forward < 5; forward++) {
            car1.forward();
        }

        for (int forward = 0; forward < 7; forward++) {
            car2.forward();
        }

        for (int forward = 0; forward < 3; forward++) {
            car3.forward();
        }
        carList = new ArrayList<>(Arrays.asList(car1, car2, car3));
        racingCars = new RacingCars(carList);
    }

    @Test
    void 우승자가_한명인_경우_pickWinner_메서드로_우승자의_이름리스트를_반환() {
        List<String> winnersName = winnerPicker.pickWinner(racingCars);
        assertThat(winnersName.size()).isEqualTo(1);
        assertThat(winnersName).contains(CAR2_NAME);
    }

    @Test
    void 우승자가_두명인_경우_pickWinner_메서드로_우승자의_이름리스트를_반환() {
        RacingCar car4 = new RacingCar(CAR4_NAME);

        for (int forward = 0; forward < 7; forward++) {
            car4.forward();
        }

        carList.add(car4);
        racingCars = new RacingCars(carList);

        List<String> winnersName = winnerPicker.pickWinner(racingCars);

        assertThat(winnersName.size()).isEqualTo(2);
        assertThat(winnersName).contains(CAR2_NAME, CAR4_NAME);
    }
}
