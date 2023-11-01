package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import domain.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    @DisplayName("Car moveCount 증가 확인")
    void move_or_stop_check() {
        Car car = new Car("test");

        // 랜덤 숫자를 4 이상으로 입력
        car.moveOrStop(4);
        assertThat(car.getMoveCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차 이름 일치 확인")
    void car_name_match_check() {
        String expectedName = "test";
        Car car = new Car(expectedName);

        assertThat(car.getCarName()).isEqualTo(expectedName);
    }
}
