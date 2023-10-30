package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    @DisplayName("자동차 정보 반환 테스트 - 정상 데이터 - 성공")
    void provideCarStatusTest() {
        Car car = new Car("pobi");

        assertThat(car.provideCarStatus().get("name")).isEqualTo("pobi");
        assertThat(car.provideCarStatus().get("position")).isEqualTo(0);
    }

    @Test
    @DisplayName("위치 이동 적용 테스트 - 정상 데이터 - 성공")
    void calculatePositionTest() {
        Car car = new Car("pobi");

        int moveTimes = 5;
        for (int expectedResult = 1; expectedResult <= moveTimes; expectedResult++) {
            car.calculatePosition(true);
            assertThat(car.provideCarStatus().get("position")).isEqualTo(expectedResult);
        }
    }
}
