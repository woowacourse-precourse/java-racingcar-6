package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    private static final int SUCCESS_MOVE_NUMBER = 4;
    private static final int FAIL_MOVE_NUMBER = 3;

    @ParameterizedTest
    @ValueSource(strings = {"Ahri", "Yasuo", "Jinx"})
    void 자동차_생성시_이름을_입력하면_값을_가진_객체를_반환한다(String carName) {
        Car car = new Car(carName);

        assertThat(car.getName()).isEqualTo(carName);
    }

    @Test
    void 자동차가_전진한만큼_위치_값이_증가한다() {
        //given
        Car ahriCar = new Car("Ahri");
        Car yasuoCar = new Car("yasuo");

        //when
        IntStream.range(0, 3)
                .forEach(i -> ahriCar.run(SUCCESS_MOVE_NUMBER));
        yasuoCar.run(SUCCESS_MOVE_NUMBER);

        //then
        assertThat(ahriCar.getPosition()).isEqualTo(3);
        assertThat(yasuoCar.getPosition()).isEqualTo(1);
    }

    @Test
    void 자동차가_이동시_임계치_이하의_숫자일_경우_멈춘다() {
        //given
        Car car = new Car("Ahri");

        //when
        car.run(FAIL_MOVE_NUMBER);

        //then
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 자동차_생성시_이름이_NULL이면_예외_발생() {
        assertThatThrownBy(() -> new Car(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_생성시_이름의_길이가_0이면_예외_발생() {
        assertThatThrownBy(() -> new Car(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_생성시_이름의_길이가_5보다_크면_예외_발생() {
        assertThatThrownBy(() -> new Car("abcdef"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "Ahri ", " Yasuo", "Ji nx"})
    void 자동차_생성시_이름에_공백이_있는_경우_예외_발생(String inputCarName) {
        assertThatThrownBy(() -> new Car(inputCarName))
                .isInstanceOf(IllegalArgumentException.class);
    }
}