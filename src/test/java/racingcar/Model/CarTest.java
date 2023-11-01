package racingcar.Model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    @DisplayName("차 객체 생성 테스트")
    public void 차_객체_생성_테스트() {
        Car pobiCar = new Car("pobi");
        Car woniCar = new Car("woni");

        assertThat(pobiCar)
                .usingRecursiveComparison()
                .isNotEqualTo(woniCar);
    }

    @Test
    @DisplayName("차 위치 이동 및 위치 조회 테스트")
    public void 차_이동_및_위치조회_테스트() {
        Car pobiCar = new Car("pobi");
        pobiCar.MoveOneStepForward();

        assertThat(pobiCar.getLocation()).isEqualTo(1);
    }

    @Test
    @DisplayName("차 이름 조회 메서드 테스트")
    public void 차_이름_조회_메서드_테스트() {
        Car pobiCar = new Car("pobi");

        assertThat(pobiCar.getCarName()).isEqualTo("pobi");
    }
}
