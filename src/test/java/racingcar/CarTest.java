package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {
    @Test
    @DisplayName("자동차 전진 대쉬 변환 테스트")
    void 자동차_전진_대쉬_변환_테스트() {
        Car car = new Car("pobi");

        car.goForward();
        car.goForward();
        car.goForward();
        String drawDash = car.positionDrawDash();

        assertThat(drawDash).isEqualTo("---");
    }

    @Test
    @DisplayName("자동차 정보 반환 테스트")
    void 자동차_정보_반환_테스트() {
        Car car = new Car("woni");

        car.goForward();
        car.goForward();
        car.goForward();
        car.goForward();
        Map<String, String> carInfo = car.getCarInfo();
        String carName = carInfo.get("name");
        String position = carInfo.get("position");

        Assertions.assertThat(carName).isEqualTo("woni");
        Assertions.assertThat(position).isEqualTo("----");
    }
}
