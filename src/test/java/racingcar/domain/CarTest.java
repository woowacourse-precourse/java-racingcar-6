package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void getName_Class_에_이름_넣기() {
        String name = "pobi";
        Car car = new Car(name);

        String carName = car.getName();

        assertThat(carName).isEqualTo(name);
    }

    @Test
    void getMoveState_초기_상태에서_0을_반환() {
        Car car = new Car("pobi");

        int moveState = car.getMoveState();

        assertThat(moveState).isEqualTo(0);
    }

    @Test
    void move_랜덤_숫자가_4_이상일_경우_움직임_상태가_1_증가() {
        Car car = new Car("pobi");

        car.move();

        assertThat(car.getMoveState()).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(1);
    }
}
