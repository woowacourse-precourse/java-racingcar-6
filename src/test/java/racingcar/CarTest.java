package racingcar;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CarTest {
    @Test
    void Car_인스턴스_생성확인() {
        Car car = new Car("kim");
    }

    @Test
    void getCarName_동작확인() {
        Car car = new Car("da");
        String carName = car.getCarName();
        assertThat(carName).isEqualTo("da");
    }

    @Test
    void getPosition_동작확인() {
        Car car = new Car("bo");
        int position = car.getPosition();
        assertThat(position).isEqualTo(0);
    }

    @Test
    void move_동작확인() {
        Car car = new Car("mi");
        int prevPosition = car.getPosition();
        car.move(new MoveStatus());
        int nextPosition = car.getPosition();
        assertThat(nextPosition).isGreaterThanOrEqualTo(prevPosition);
    }
}