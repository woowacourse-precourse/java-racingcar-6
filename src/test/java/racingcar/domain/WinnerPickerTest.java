package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnerPickerTest {

    private WinnerPicker winnerPicker;
    private Cars cars;
    private List<String> carNames;
    private static final String CAR1_NAME = "pobi";
    private static final String CAR2_NAME = "woni";
    private static final String CAR3_NAME = "jun";
    private static final String CAR4_NAME = "umi";

    @BeforeEach
    void setUp() {
        winnerPicker = new WinnerPicker();
        carNames = new ArrayList<>(Arrays.asList(CAR1_NAME, CAR2_NAME, CAR3_NAME));
        cars = new Cars(carNames);

    }

    @Test
    void 우승자가_한명인_경우_pickWinner_메서드로_우승자의_이름리스트를_반환() {

        Car car1 = cars.getCars().get(0);
        Car car2 = cars.getCars().get(1);
        Car car3 = cars.getCars().get(2);

        for (int forward = 0; forward < 5; forward++) {
            car1.forward();
        }

        for (int forward = 0; forward < 7; forward++) {
            car2.forward();
        }

        for (int forward = 0; forward < 3; forward++) {
            car3.forward();
        }

        Winners winners = winnerPicker.pickWinner(cars);
        assertThat(winners.getWinnersName().size()).isEqualTo(1);
        assertThat(winners.getWinnersName()).contains(CAR2_NAME);
    }

    @Test
    void 우승자가_두명인_경우_pickWinner_메서드로_우승자의_이름리스트를_반환() {
        carNames.add(CAR4_NAME);
        cars = new Cars(carNames);

        Car car1 = cars.getCars().get(0);
        Car car2 = cars.getCars().get(1);
        Car car3 = cars.getCars().get(2);
        Car car4 = cars.getCars().get(3);

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

        Winners winners = winnerPicker.pickWinner(cars);

        assertThat(winners.getWinnersName().size()).isEqualTo(2);
        assertThat(winners.getWinnersName()).contains(CAR2_NAME, CAR4_NAME);
    }
}
