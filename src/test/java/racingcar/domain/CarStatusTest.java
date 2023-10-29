package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarStatusTest {
    private CarStatus testCarStatus;
    @BeforeEach
    void init() {
        testCarStatus = CarStatus.create("test");
    }

    @DisplayName("입력 객체의 위치와 현재 자동차 객체의 위치가 일치하면 true를 반환한다")
    @Test
    void isSamePositionReturnTrue() {
        CarStatus otherCar = CarStatus.create("other");

        assertThat(testCarStatus.isSamePosition(otherCar)).isEqualTo(true);
    }
}
