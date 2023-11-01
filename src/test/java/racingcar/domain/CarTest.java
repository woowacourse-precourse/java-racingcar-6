package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void createTest() {
        assertThatCode(() -> new Car(new CarName("테스트"), new FixedCarEngine(true), new Position()))
                .doesNotThrowAnyException();
    }


    @DisplayName("자동차의 엔진이 움직일 수 있으면 1칸 전진한다.")
    @Test
    void startEngineSuccessTest() {
        Car car = new Car(new CarName("테스트"), new FixedCarEngine(true), new Position());
        assertThat(car.getPosition()).isEqualTo(0);
        car.startEngine();
        assertThat(car.getPosition()).isEqualTo(1);
        car.startEngine();
        assertThat(car.getPosition()).isEqualTo(2);
    }

    @DisplayName("자동차의 엔진이 움직일 수 없으면 전진하지 않는다.")
    @Test
    void startEngineFailTest() {
        Car car = new Car(new CarName("테스트"), new FixedCarEngine(false), new Position());
        assertThat(car.getPosition()).isEqualTo(0);
        car.startEngine();
        assertThat(car.getPosition()).isEqualTo(0);
        car.startEngine();
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
