package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    private static final String CAR_NAME = "pobi";

    @Test
    public void 자동차_이름의_길이가_1보다_작으면_예외_발생() {
        // given
        final String carName = "";

        // then
        Assertions.assertThatThrownBy(() -> new Car(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 자동차_이름의_길이가_5보다_크면_예외_발생() {
        // given
        final String carName = "porsche";

        // then
        Assertions.assertThatThrownBy(() -> new Car(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {" pobi", "p obi", "pobi "})
    public void 자동차_이름에_공백이_포함된_경우_예외_발생(String carName) {
        Assertions.assertThatThrownBy(() -> new Car(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    public void 앞으로_움직이지_않는_경우_테스트(int randomNumber) {
        // given
        Car car = new Car(CAR_NAME);

        // when
        String location = car.move(randomNumber);

        // then
        assertEquals(location, CAR_NAME + " : " + "");
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    public void 앞으로_움직인_경우_테스트(int randomNumber) {
        // given
        Car car = new Car(CAR_NAME);

        // when
        String location = car.move(randomNumber);

        // then
        assertEquals(location, CAR_NAME + " : " + "-");
    }
}