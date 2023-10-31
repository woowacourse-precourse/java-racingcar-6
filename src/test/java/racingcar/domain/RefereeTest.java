package racingcar.domain;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RefereeTest {

    Referee referee = new Referee();
    @Test
    @RepeatedTest(20)
    void 우승자를_올바르게_뽑아내는지_확인() {
        List<RandomCar> randomCars = new ArrayList<>();

        RandomCar car5 = new RandomCar("랜덤값이 5만 나오는 자동차", () -> 5);
        RandomCar car4 = new RandomCar("랜덤값이 4만 나오는 자동차", () -> 4);
        RandomCar car3 = new RandomCar("랜덤값이 3만 나오는 자동차", () -> 3);

        car5.move();
        car4.move();
        car3.move();

        randomCars.add(car5);
        randomCars.add(car3);
        randomCars.add(car4);

        List<RandomCar> winners = referee.selectWinners(randomCars);

        for (RandomCar winner : winners) {
            assertThat(winner.getName()).isIn("랜덤값이 5만 나오는 자동차", "랜덤값이 4만 나오는 자동차");
            assertThat(winner.getName()).isNotIn("랜덤값이 3만 나오는 자동차");
        }
    }
}