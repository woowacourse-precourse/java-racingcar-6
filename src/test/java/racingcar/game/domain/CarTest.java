package racingcar.game.domain;

import org.junit.jupiter.api.Test;
import racingcar.game.constant.CarExceptionMessage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.game.constant.CarExceptionMessage.*;

class CarTest {

    @Test
    void 자동차_생성() {
        assertSuccessfullyCreate("hwang");
    }

    @Test
    void 이름이_6자_이상이면_자동차_생성X() {
        assertExceptionCase("avante", OUT_OF_RANGE);
    }

    @Test
    void 자동차_전진_시도_후_상태_체크() {
        Car car = Car.create("hwang");

        for (int i = 0; i < 5; i++) {
            car.tryForward();
        }

        StringBuilder forwardState = car.getForwardState();
        assertThat(car.getCarState()).isEqualTo("hwang : " + forwardState);
    }

    @Test
    void 자동차_이름_중간에_공백이_포함돼도_자동차_생성_가능() {
        assertSuccessfullyCreate("ju ng");
    }

    @Test
    void 자동차_이름_양끝에_공백이_포함되면_자동차_생성X() {
        assertExceptionCase(" jung", NOT_ALLOW_SIDE_BLANK);
        assertExceptionCase("jung ", NOT_ALLOW_SIDE_BLANK);
    }

    @Test
    void 자동차_이름이_null_이면_자동차_생성X() {
        assertExceptionCase(null, SHOULD_HAVE_VALUE);
    }

    @Test
    void 자동차_이름이_빈_문자열이면_자동차_생성X() {
        assertExceptionCase("", OUT_OF_RANGE);
    }

    private void assertSuccessfullyCreate(String carName) {
        Car car = Car.create(carName);
        assertThat(car).isNotNull();
    }

    private void assertExceptionCase(String carName, String errorMessage) {
        assertThatThrownBy(() -> Car.create(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(errorMessage);
    }

}