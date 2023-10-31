package racingcar.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.race.Race;

class CarTest {
    private Race race;

    @BeforeEach
    void SetUp() {
        this.race = new Race();
    }

    @Test
    void 차_움직임_테스트() {
        String carName = "jeyhcuk";

        Car car = new Car(carName);
        int[] valueArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] answerArray = {0, 0, 0, 1, 2, 3, 4, 5, 6};

        for (int i = 0; i < 9; i++) {
            race.handleCar(car, valueArray[i]);

            assertThat(car.outputResult()
                    .getCarName())
                    .isEqualTo(carName);
            assertThat(car.outputResult()
                    .getDistance())
                    .isEqualTo(answerArray[i]);
        }
    }
}