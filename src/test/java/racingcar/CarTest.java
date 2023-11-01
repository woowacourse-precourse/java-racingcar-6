package racingcar;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.race.Car;
import racingcar.race.MoveStatus;

class CarTest {
    Car car = new Car("kim");
    @Test
    @DisplayName("자동차 인스턴스 생성 확인")
    void Car_인스턴스_생성확인() {
        Car car = new Car("kim");
    }

    @Test
    @DisplayName("자동차 이름 불러오기 동작확인")
    void getCarName_동작확인() {
        String carName = car.getCarName();
        assertThat(carName).isEqualTo("kim");
    }

    @Test
    @DisplayName("자동차 위치 불러오기 동작확인")
    void getPosition_동작확인() {
        int position = car.getPosition();
        assertThat(position).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차 이동 동작확인")
    void move_동작확인() {
        int prevPosition = car.getPosition();
        car.move(new MoveStatus());
        int nextPosition = car.getPosition();
        assertThat(nextPosition).isGreaterThanOrEqualTo(prevPosition);
    }
}