package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.Car;

public class CarTest {

    private Car car;

    @BeforeEach
    public void setUp() {
        car = new Car("pobi");
    }

    @Test
    public void createCar() {
        Car newCar = new Car("woni");
        assertThat(newCar.getName()).isEqualTo("woni");
        assertThat(newCar.getPosition()).isEqualTo(0);
    }

    @DisplayName("전진 여부를 정하기 위한 난수가 4 이상인 경우 확인(전진하는 경우)")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    public void checkMoveTrue(int number) {
        car.move(number);
        int position = car.getPosition();
        assertThat(position).isEqualTo(1);
    }

    @DisplayName("전진 여부를 정하기 위한 난수가 3 이하인 경우 확인(전진하지 않는 경우)")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void checkMoveFalse(int number) {
        car.move(number);
        int position = car.getPosition();
        assertThat(position).isEqualTo(0);
    }

}
