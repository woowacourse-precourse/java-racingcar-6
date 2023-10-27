package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    private Car car;
    private Long beforePosition;

    @BeforeEach
    void setUp() {
        car = RacingCar.of("pobi");
        beforePosition = car.getPosition();
    }

    @Test
    @DisplayName("무작위의 숫자(0~9)을 돌려서.. 4이상이면 전진")
    void forward_when_largerThan_4_randomNumber() {
        car = car.runAndReturnNewCar(stubRandom(4L));
        assertThat(car.getPosition()).isEqualTo(beforePosition + 1);
    }

    @Test
    @DisplayName("무작위 숫자(0~9)을 돌려서.. 4미만이면 정지")
    void stop_when_less_than_4_randomNumber() {
        car = car.runAndReturnNewCar(stubRandom(3L));
        assertThat(car.getPosition()).isEqualTo(beforePosition);
    }

    @Test
    @DisplayName("차량이 이동한 만큼 출력")
    void print_carMove() {
        Car car1 = RacingCar.of("pobi");
        car1 = car1.runAndReturnNewCar(stubRandom(4L));
        assertThat(car1.getCarStatus()).isEqualTo("pobi : -");

        Car car2 = RacingCar.of("woni");
        assertThat(car2.getCarStatus()).isEqualTo("woni : ");
    }

    private Long stubRandom(Long val) {
        return val;
    }
}
