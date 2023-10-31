package racingcar.carState;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.validator.CarNameValidator;

import static org.assertj.core.api.Assertions.assertThat;

public class CarStateTest {
    @Test
    void 차_이름_입력_테스트() {
        CarNameValidator validator = new CarNameValidator("1,2");
        assertThat(validator.NAMES).contains("2", "1");
        assertThat(validator.NAMES).containsExactly("1", "2");
    }

    @Test
    void 차_직진_X_테스트(){
        for (int i = 0; i <= 3; i++) {
            Car car = new Car("Hyun");
            car.move(i);
            assertThat(car.getCarPosition()).isEqualTo(0);
        }
    }

    @Test
    void 차_직진_O_테스트(){
        for (int i = 4; i <= 9; i++) {
            Car car = new Car("Hyun");
            car.move(i);
            assertThat(car.getCarPosition()).isEqualTo(1);
        }
    }

    @Test
    void 차_위치_반환_테스트(){
        Car car = new Car("Hyun");
        assertThat(car.getCarPosition()).isEqualTo(0);
    }

    @Test
    void 차_이름_반환_테스트(){
        String Name = "Hyun";
        Car car = new Car(Name);
        assertThat(car.getCarName()).isEqualTo(Name);
    }
}