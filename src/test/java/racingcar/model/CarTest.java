package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CarTest {
    private static final String JACK = "jack";
    private static final String CRONG = "crong";
    private static final MovementCondition MOVABLE = () -> true;
    private static final MovementCondition IMMOVABLE = () -> false;

    @Test
    void 자동차는_이름을_통해_처음_생성하면_내부적으로_위치값이_기본상태를_갖는다() {
        Car expectedCar = createCar(JACK, 0);

        Car actualCar = Car.from(JACK);

        assertThat(actualCar).isEqualTo(expectedCar);
    }

    @Test
    void 자동차가_전진하면_위치값이_증가한다() {
        Car car = createCar(JACK, 0);
        Car expectedCar = createCar(JACK, 1);

        Car actualCar = car.move(MOVABLE);

        assertThat(actualCar).isEqualTo(expectedCar);
    }

    @Test
    void 자동차가_전진하지_않으면_위치값은_고정된다() {
        Car car = createCar(JACK, 0);
        Car expectedCar = createCar(JACK, 0);

        Car actualCar = car.move(IMMOVABLE);

        assertThat(actualCar).isEqualTo(expectedCar);
    }

    @Test
    void 자동차의_위치값이_최대값과_같으면_참을_반환한다() {
        Car car = createCar(JACK, 5);
        CarPosition maxPosition = new CarPosition(5);

        boolean actualResult = car.isSamePosition(maxPosition);

        assertThat(actualResult).isTrue();
    }

    @Test
    void 자동차의_위치값이_최대값과_일치하지_않으면_거짓을_반환한다() {
        Car car = createCar(JACK, 4);
        CarPosition maxPosition = new CarPosition(5);

        boolean actualResult = car.isSamePosition(maxPosition);

        assertThat(actualResult).isFalse();
    }

    @Test
    void 자동차의_이름과_이동위치가_같다면_서로_같은_객체이다() {
        Car actualCar = createCar(JACK, 0);
        Car expectedCar = createCar(JACK, 0);

        assertThat(actualCar).isEqualTo(expectedCar);
    }

    @Test
    void 자동차의_이름과_이동위치가_다르다면_서로_다른_객체이다() {
        Car actualCar = createCar(JACK, 0);
        Car expectedCar = createCar(CRONG, 0);

        assertThat(actualCar).isNotEqualTo(expectedCar);
    }

    @Test
    void 자동차의_이름과_이동위치가_같다면_동일한_해시코드를_가진다() {
        Car actualCar = createCar(JACK, 0);
        Car expectedCar = createCar(JACK, 0);

        assertThat(actualCar.hashCode()).isEqualTo(expectedCar.hashCode());
    }

    private Car createCar(String name, int position) {
        CarName carName = CarName.from(name);
        CarPosition carPosition = new CarPosition(position);
        return new Car(carName, carPosition);
    }

}
