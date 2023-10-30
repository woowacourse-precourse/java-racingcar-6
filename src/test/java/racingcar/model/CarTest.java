package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CarTest {
    @Test
    void 자동차는_4_이상의_숫자가_주어지면_전진한다() {
        // given
        Car car = new Car("myCar");
        car.moveCar(4);

        // when then
        assertThat(car).extracting("distance")
                .isEqualTo(1);
    }

    @Test
    void 자동차는_4_미만의_숫자가_주어지면_정지한다() {
        //given
        Car car = new Car("myCar");
        car.moveCar(3);

        // when then
        assertThat(car).extracting("distance")
                .isEqualTo(0);
    }

    @Test
    void 자동차는_서로의_이동거리를_비교한다() {
        // given
        Car myCar = new Car("my");
        myCar.moveCar(4);

        Car yourCar = new Car("your");
        yourCar.moveCar(3);

        // when
        int compareResult = myCar.compareTo(yourCar);

        // then
        assertThat(compareResult).isEqualTo(1);
    }

    @Test
    void 자동차는_서로의_이동거리가_같은지_확인한다() {
        // given
        Car myCar = new Car("my");
        myCar.moveCar(4);

        Car yourCar = new Car("your");
        yourCar.moveCar(4);

        // when
        boolean isSameDistance = myCar.isSameDistanceAs(yourCar);

        // then
        assertThat(isSameDistance).isEqualTo(true);
    }

    @Test
    void 자동차는_자신의_이름을_반환한다() {
        // given
        Car myCar = new Car("myCar");

        // when
        String name = myCar.getCarName();

        // then
        assertThat(name).isEqualTo("myCar");
    }
}