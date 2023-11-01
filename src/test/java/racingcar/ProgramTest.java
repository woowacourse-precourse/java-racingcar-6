package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class ProgramTest {

    RacingProgram racingProgram = new RacingProgram();
    CarRepository carRepository = new CarRepository();

    @Test
    void 자동차_생성() {
        String carName = "pobi";
        Car car = new Car(carName);

        assertThat(car.getName()).isEqualTo(carName);
    }

    @Test
    void 자동차_전진() {
        Car car = new Car("pobi");
        carRepository.add(car);
        carRepository.setCarForward();
        if (car.setRandomNumber() >= 4) {
            assertThat(car.getForward()).isEqualTo("-");
        } else {
            assertThat(car.getForward()).isEqualTo("");
        }
    }
}
