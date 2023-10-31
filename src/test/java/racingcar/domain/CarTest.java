package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("자동차가 3이하의 수를 입력 받으면, forwardCount 가 증가하지 않음")
    void 자동차_전진_테스트_3이하의수() {
        Car car = new Car("hyeongil");
        car.forward(3);

        assertThat(car.getForwardCount())
                .isEqualTo(0);
    }

    @Test
    @DisplayName("자동차가 4이상의 수를 입력 받으면, forwardCount 가 증가한다")
    void 자동차_전진_테스트_4이상의수() {
        Car car = new Car("hyeongil");
        car.forward(4);

        assertThat(car.getForwardCount())
                .isEqualTo(1);
    }

    @Test
    @DisplayName("자동차의 ForwardCount 가 전체 자동차의 ForwardCount 보다 크면 승리")
    void 승리_테스트() {
        Car car1 = new Car("h");
        car1.forward(5);

        Car car2 = new Car("h");
        car2.forward(3);

        Car car3 = new Car("h");
        car3.forward(2);

        assertThat(List.of(car1.getForwardCount(),
                car2.getForwardCount(),
                car2.getForwardCount()))
                .isEqualTo(List.of(1, 0, 0));
    }

    @Test
    @DisplayName("ForwardCount가 같은 자동차가 여러개 일때, 모두 승리")
    void 다수승리_테스트() {
        Car car1 = new Car("h");
        car1.forward(5);

        Car car2 = new Car("h");
        car2.forward(4);

        Car car3 = new Car("h");
        car3.forward(4);

        assertThat(List.of(car1.getForwardCount(),
                car2.getForwardCount(),
                car2.getForwardCount()))
                .isEqualTo(List.of(1, 1, 1));
    }

}