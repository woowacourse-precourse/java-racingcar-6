package racingcar.domain;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class CarTest extends NsTest {

    private static final String CAR_NAME = "BMW";
    private static final String FORWARD = "1";
    private static final String STOP = "0";
    private static final int ZERO = 0;

    @ParameterizedTest
    @ValueSource(strings = {"popobi", "ianbest", "abcdefgh"})
    public void 자동차의_이름은_5글자를_넘을수없다(String carName) {
        // when, then
        Assertions.assertThatThrownBy(() -> new Car(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 자동차_이름이_올바른_경우_Car_객체를_생성할_수_있다() {
        // given, when
        Car car = new Car(CAR_NAME);

        // then
        Assertions.assertThat(car).isNotNull();
    }

    @Test
    public void 자동차의_초기_위치는_0이다() {
        // given
        Car car = new Car(CAR_NAME);

        // when
        int actual = car.getPosition();

        // then
        Assertions.assertThat(actual).isEqualTo(ZERO);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7})
    public void 랜덤값이_전진하는_기준보다_크면_전진한다(int randomNumber) {
        // when, then
        assertRandomNumberInRangeTest(
                () -> {
                    run();
                    assertThat(output()).contains(FORWARD);
                },
                randomNumber
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    public void 랜덤값이_전진하는_기준보다_작으면_멈춘다(int randomNumber) {
        // when, then
        assertRandomNumberInRangeTest(
                () -> {
                    run();
                    assertThat(output()).contains(STOP);
                },
                randomNumber
        );
    }

    @Override
    public void runMain() {
        // given
        Car car = new Car(CAR_NAME);

        // when
        car.progress();

        // then
        System.out.println(car.getPosition());
    }

}