package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.controller.Race;
import racingcar.model.Car;
import racingcar.util.Computer;

public class RaceTest {
    private Race race;

    @BeforeEach
    void setUp() {
        race = new Race();
    }

    @Test
    void 랜덤숫자_범위_테스트() {
        Computer computer = new Computer();
        for (int i = 0; i < 10; i++) {
            int result = computer.getRandomNumber();
            assertThat(result).isBetween(0, 9);
        }
    }

    @Test
    void 전진을_결정하는_랜덤숫자_체크_테스트() {
        int randomNumber0 = 0;
        int randomNumber1 = 1;
        int randomNumber2 = 2;
        int randomNumber3 = 3;
        int randomNumber4 = 4;
        int randomNumber5 = 5;
        int randomNumber6 = 6;
        int randomNumber7 = 7;
        int randomNumber8 = 8;
        int randomNumber9 = 9;

        assertThat(race.checkForward(randomNumber0)).isEqualTo(false);
        assertThat(race.checkForward(randomNumber1)).isEqualTo(false);
        assertThat(race.checkForward(randomNumber2)).isEqualTo(false);
        assertThat(race.checkForward(randomNumber3)).isEqualTo(false);
        assertThat(race.checkForward(randomNumber4)).isEqualTo(true);
        assertThat(race.checkForward(randomNumber5)).isEqualTo(true);
        assertThat(race.checkForward(randomNumber6)).isEqualTo(true);
        assertThat(race.checkForward(randomNumber7)).isEqualTo(true);
        assertThat(race.checkForward(randomNumber8)).isEqualTo(true);
        assertThat(race.checkForward(randomNumber9)).isEqualTo(true);
    }

    @Test
    void 전진_테스트() {
        Car car = new Car("car1", 0);

        car.addDistance();
        assertThat(car.getDistance()).isEqualTo(1);
    }
}
