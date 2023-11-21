package racingcar.domain.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.RacingException;

class CarNameTest {

    @ParameterizedTest(name = "{0}은 정상 이름이다.")
    @ValueSource(strings = {"pobi", "woni", "jun"})
    @DisplayName("[SUCCESS] 정상 이름 테스트")
    void 정상_이름(String name) {
        Assertions.assertThatNoException()
                .isThrownBy(() -> new CarName(name));
    }

    @ParameterizedTest(name = "{0}은 잘못된 이름이다.")
    @ValueSource(strings = {"zangsu", "junjunk"})
    @DisplayName("[EXCEPTION] 5글자를 넘는 이름을 사용하면 예외가 발생한다.")
    void 이름_길이_테스트(String name) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new CarName(name))
                .withMessage(RacingException.INVALID_CARS_NAME.getMessage());
    }

    @ParameterizedTest(name = "{0}은 잘못된 이름이다.")
    @ValueSource(strings = {"", " "})
    @DisplayName("[EXCEPTION] 빈 값의 이름을 사용하면 예외가 발생한다.")
    void 이름_빈값_테스트(String name) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new CarName(name))
                .withMessage(RacingException.INVALID_CARS_NAME.getMessage());
    }

}