package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    private static final String CAR_NAME = "pobi";

    private Name carName;

    @BeforeEach
    public void beforeEach() {
        carName = new Name(CAR_NAME);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    public void 앞으로_움직이지_않는_경우_테스트(int randomNumber) {
        // given
        final Car car = new Car(carName);

        // when
        final Car unmovedCar = car.move(randomNumber);

        // then
        assertEquals(unmovedCar.toString(), CAR_NAME + " : " + "");
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    public void 앞으로_움직인_경우_테스트(int randomNumber) {
        // given
        final Car car = new Car(carName);

        // when
        final Car movedCar = car.move(randomNumber);

        // then
        assertEquals(movedCar.toString(), CAR_NAME + " : " + "-");
    }
}