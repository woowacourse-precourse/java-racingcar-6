package racingcar.game.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @Test
    void 자동차_생성() {
        assertSuccessfullyCreate("hwang");
    }

    @Test
    void 이름이_6자_이상이면_자동차_생성X() {
        assertExceptionCase("avante", "자동차의 이름이 1~5자 사이가 아닙니다.");
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
        assertExceptionCase(" jung", "자동차 이름의 양 끝에는 공백이 올 수 없습니다.");
        assertExceptionCase("jung ", "자동차 이름의 양 끝에는 공백이 올 수 없습니다.");
    }

    @Test
    void 자동차_이름이_null_이면_자동차_생성X() {
        assertExceptionCase(null, "자동차의 이름은 필수값입니다.");
    }

    @Test
    void 자동차_이름이_빈_문자열이면_자동차_생성X() {
        assertExceptionCase("", "자동차의 이름이 1~5자 사이가 아닙니다.");
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