package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    public void testCarConstructZeroChar() {
        assertThatThrownBy(() -> new Car("", 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testCarConstructSixChar() {
        assertThatThrownBy(() -> new Car("abcdef", 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testCarConstructNegativeDistance() {
        assertThatThrownBy(() -> new Car("", -1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testCarToString() {
        Car pobiCar = new Car("pobi", 0);
        assertThat(pobiCar.toString()).isEqualTo("pobi : ");

        Car woniCar = new Car("woni", 1);
        assertThat(woniCar.toString()).isEqualTo("woni : -");
    }

    @Test
    public void testCarForwardRandomOne() {
        Car car = new Car("pobi", 0);
        car.forward((lowerBound, upperBound) -> 1);
        assertThat(car.toString()).isEqualTo("pobi : ");
    }

    @Test
    public void testCarForwardRandomFour() {
        Car car = new Car("pobi", 0);
        car.forward((lowerBound, upperBound) -> 4);
        assertThat(car.toString()).isEqualTo("pobi : -");
    }

    @Test
    public void testCarForwardRandomNine() {
        Car car = new Car("pobi", 0);
        car.forward((lowerBound, upperBound) -> 9);
        assertThat(car.toString()).isEqualTo("pobi : -");
    }
}
