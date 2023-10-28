package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 자동차는_이름을_통해_처음_생성되는_경우_내부적으로_위치값이_기본상태를_갖는다() {
        Car expectedCar = createCarWithPosition("jack", 0);

        Car actualCar = Car.from("jack");

        assertThat(actualCar).isEqualTo(expectedCar);
    }

    @Test
    void 자동차가_전진하면_위치값이_증가한다() {
        Car car = createCarWithPosition("jack", 0);
        Car expectedCar = createCarWithPosition("jack", 1);
        MovementCondition movable = () -> true;

        Car actualCar = car.move(movable);

        assertThat(actualCar).isEqualTo(expectedCar);
    }

    @Test
    void 자동차가_전진하지_않으면_위치값은_고정된다() {
        Car car = createCarWithPosition("jack", 0);
        Car expectedCar = createCarWithPosition("jack", 0);
        MovementCondition immovable = () -> false;

        Car actualCar = car.move(immovable);

        assertThat(actualCar).isEqualTo(expectedCar);
    }

    @Test
    void 자동차의_위치값이_최대값과_같으면_참을_반환한다() {
        Car car = createCarWithPosition("jack", 5);
        CarPosition maxPosition = new CarPosition(5);

        boolean actualResult = car.isSamePosition(maxPosition);

        assertThat(actualResult).isTrue();
    }

    @Test
    void 자동차의_위치값이_최대값과_일치하지_않으면_거짓을_반환한다() {
        Car car = createCarWithPosition("jack", 4);
        CarPosition maxPosition = new CarPosition(10);

        boolean actualResult = car.isSamePosition(maxPosition);

        assertThat(actualResult).isFalse();
    }

    @Test
    void 자동차의_이름과_이동위치가_같다면_서로_같은_객체이다() {
        Car actualCar = createCarWithPosition("jack", 0);
        Car expectedCar = createCarWithPosition("jack", 0);

        assertThat(actualCar).isEqualTo(expectedCar);
    }

    private Car createCarWithPosition(String name, int position) {
        CarName carName = CarName.from(name);
        CarPosition carPosition = new CarPosition(position);
        return new Car(carName, carPosition);
    }

}
