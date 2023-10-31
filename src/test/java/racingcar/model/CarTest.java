package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.dto.CarStatus;

public class CarTest {

    private Car car;

    @BeforeEach
    void setup() {
        Name name = new Name("name");
        car = new Car(name);
    }

    @Test
    void 전진_성공_테스트() {
        car.run(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 전진_실패_테스트() {
        car.run(3);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 현재_자동차_위치_정보_테스트() {
        car.run(4);
        CarStatus carStatus = new CarStatus(car);

        String carStatusString = carStatus.getName()
                + " : "
                + "-".repeat(carStatus.getPosition());

        assertThat(carStatusString).isEqualTo("name : -");
    }
}