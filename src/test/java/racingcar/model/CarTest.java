package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    private String name = "dawin";

    @Test
    void moveForward_자동차의_이동_거리가_1_증가() {
        // given
        Car car = new Car(name);
        int nowDistance = car.getDistance();
        int movedDistance = nowDistance + 1;

        // when
        car.moveForward();

        // then
        assertThat(car.getDistance()).isEqualTo(movedDistance);
    }

    @Test
    void moveForward_메서드_5회_호출시_자동차의_이동_거리가_5_증가() {
        // given
        Car car = new Car(name);
        int nowDistance = car.getDistance();
        int movedDistance = nowDistance + 5;

        // when
        for(int i = 0; i < 5; i++) {
            car.moveForward();
        }

        // then
        assertThat(car.getDistance()).isEqualTo(movedDistance);
    }

    @Test
    void getName_자동차_이름_반환() {
        //given
        Car car = new Car(name);

        //when
        String carName = car.getName();

        //then
        assertThat(carName).isEqualTo(name);
    }

    @Test
    void getDistance_자동차_이동_거리_반환() {
        //given
        Car car = new Car(name);
        int defaultDistance = 0;

        //when
        int distance = car.getDistance();

        //then
        assertThat(distance).isEqualTo(defaultDistance);
    }
}