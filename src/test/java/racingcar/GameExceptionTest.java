package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class GameExceptionTest {
    GameException gameException = new GameException();

    @Test
    void 자동차_이름_길이_예외_테스트() {
        String carName = "cocacola";

        Assertions.assertThatThrownBy(() -> gameException.validatePlayerCarNameLengthRange(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름_소문자_예외_테스트() {
        String carName = "coCacola";

        Assertions.assertThatThrownBy(() -> gameException.validatePlayerCarNameOnlyLowerCase(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름_공백_예외_테스트1() {
        String carName = "co ca";

        Assertions.assertThatThrownBy(() -> gameException.validatePlayerCarNameBlank(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름_공백_예외_테스트2() {
        String carName = "";

        Assertions.assertThatThrownBy(() -> gameException.validatePlayerCarNameBlank(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름_타입_예외_테스트1() {
        String carName = "jun1";

        Assertions.assertThatThrownBy(() -> gameException.validatePlayerCarNameType(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름_타입_예외_테스트2() {
        String carName = "12";

        Assertions.assertThatThrownBy(() -> gameException.validatePlayerCarNameType(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }
}