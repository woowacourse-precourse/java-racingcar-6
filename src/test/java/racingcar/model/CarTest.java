package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CarTest {

    private static final String NAME_JACK = "jack";

    @Test
    void 자동차는_이름을_통해_처음_생성되는_경우_내부적으로_위치값이_기본상태를_갖는다() {
        Car expectedCar = createCarWithPosition(0);

        Car actualCar = createCarWithZeroPosition();

        assertThat(actualCar).isEqualTo(expectedCar);
    }

    @Test
    void 자동차가_전진하면_위치값이_증가한다() {
        Car car = createCarWithZeroPosition();
        Car expectedCar = createCarWithPosition(1);
        MovementCondition movable = () -> true;

        Car actualCar = car.move(movable);

        assertThat(actualCar).isEqualTo(expectedCar);
    }

    @Test
    void 자동차가_전진하지_않으면_위치값은_고정된다() {
        Car car = createCarWithZeroPosition();
        Car expectedCar = createCarWithPosition(0);
        MovementCondition immovable = () -> false;

        Car actualCar = car.move(immovable);

        assertThat(actualCar).isEqualTo(expectedCar);
    }

    @Test
    void 자동차의_위치값이_최대값과_같으면_참을_반환한다() {
        Car car = createCarWithPosition(5);
        CarPosition maxPosition = new CarPosition(5);

        boolean actualResult = car.isSamePosition(maxPosition);

        assertThat(actualResult).isTrue();
    }

    @Test
    void 자동차의_위치값이_최대값과_일치하지_않으면_거짓을_반환한다() {
        Car car = createCarWithPosition(4);
        CarPosition maxPosition = new CarPosition(10);

        boolean actualResult = car.isSamePosition(maxPosition);

        assertThat(actualResult).isFalse();
    }

    private Car createCarWithZeroPosition() {
        return Car.from(NAME_JACK);
    }

    private Car createCarWithPosition(int position) {
        CarName carName = CarName.from(NAME_JACK);
        CarPosition carPosition = new CarPosition(position);
        return new Car(carName, carPosition);
    }

}
