package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    void 자동차_객체_생성_테스트() {
        Car car = new Car("차1");
        assertThat(car).isNotNull();
    }

    @Test
    void 자동차_포지션_업데이트() {
        Car car = new Car("차1");
        car.goOrStayForwardCount(4);
        assertThat(car.goOrStayForwardCount(3)).isEqualTo(1);
    }

    @Test
    void 자동차_포지션_라운드_결과_출력() {
        Car car1 = new Car("차1");
        Car car2 = new Car("차2");
        car1.goOrStayForwardCount(4);
        car2.goOrStayForwardCount(3);
        assertThat(car1.getCurrentPosition()).isEqualTo("차1 : -");
        assertThat(car2.getCurrentPosition()).isEqualTo("차2 : ");
    }

    @Test
    void 자동차_최종_우승자_출력() {
        Car car1 = new Car("차1");
        Car car2 = new Car("차2");
        car1.goOrStayForwardCount(4);
        car2.goOrStayForwardCount(3);
        assertThat(car1.getCarNameAtMaxPosition(1)).isEqualTo("차1");
        assertThat(car2.getCarNameAtMaxPosition(1)).isEqualTo("");
    }

}
