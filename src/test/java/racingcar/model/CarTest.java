package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    private static final String PROPER_NAME = "jisoo";
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car(PROPER_NAME);
    }

    @Test
    void testCreateCar() {
        assertEquals(PROPER_NAME, car.getName());
        assertThat(car.getForwardMovementStateOfLength()).isEqualTo(0);
    }

    @Test
    void testCheckRandomWithRandomNumberLessThan4() {
        // given
        car.pickRandomNumber(0, 3);

        // when
        boolean result = car.checkRandomNumber();

        // then
        assertThat(result).isEqualTo(false);
    }

    @Test
    void testCheckRandomWithRandomNumberGreaterThan4() {
        // given
        car.pickRandomNumber(4, 9);

        // when
        boolean result = car.checkRandomNumber();

        // then
        assertThat(result).isEqualTo(true);
    }

    @Test
    void testGetNameAndStateOfCar() {
        // given
        car.pickRandomNumber(4, 9);

        // when
        car.forward();

        // then
        assertThat(car.getNameAndStateOfCar()).isEqualTo(PROPER_NAME + " : -");
    }
}