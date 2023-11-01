package racingcar;


import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.car.Car;

public class CarTest extends NsTest {

    @Test
    void 자동차_이름_확인() {
        Car car = new Car("car");
        Assertions.assertThat(car.getName()).isEqualTo("car");
    }

    @Test
    void 자동차_위치_확인() {
        Car car = new Car("car");
        Assertions.assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 값이_4_이상일때_전진_하는지_확인() {
        Car car = new Car("car");
        car.forward(4);
        Assertions.assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 값이_4_이하일때_전진_안하는지_확인() {
        Car car = new Car("car");
        car.forward(3);
        Assertions.assertThat(car.getPosition()).isNotEqualTo(1);
    }

    @Test
    void 우승자_여부_반환_확인() {
        Car car = new Car("car");
        car.forward(4);
        Assertions.assertThat(car.isWinner(1)).isEqualTo(true);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
