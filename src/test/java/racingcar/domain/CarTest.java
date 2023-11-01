package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class CarTest extends NsTest {

    @ParameterizedTest
    @ValueSource(strings = {"popobi", "ianbest", "abcdefgh"})
    public void 자동차의_이름은_5글자를_넘을수없다(String carName) {
        // when, then
        Assertions.assertThatThrownBy(() -> new Car(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 자동차의_초기_위치는_0이다() {
        // given
        Car car = new Car("MyCar");

        // when
        int actual = car.getPosition();

        // then
        Assertions.assertThat(actual).isEqualTo(0);
        car.progress();
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7})
    public void 랜덤값이_전진하는_기준보다_크면_전진한다(int randomNumber) {
        assertRandomNumberInRangeTest(
                () -> {
                    run();
                    assertThat(output()).contains("1");
                },
                randomNumber
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    public void 랜덤값이_전진하는_기준보다_작으면_멈춘다(int randomNumber) {
        assertRandomNumberInRangeTest(
                () -> {
                    run();
                    assertThat(output()).contains("0");
                },
                randomNumber
        );
    }

    @Override
    public void runMain() {
        // given
        Car car = new Car("pobi");

        // when
        car.progress();

        // then
        System.out.println(car.getPosition());
    }

}