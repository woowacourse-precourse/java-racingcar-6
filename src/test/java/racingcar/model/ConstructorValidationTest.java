package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.exception.car.carName.HasSpaceException.HAS_SPACE_EXCEPTION_MESSAGE;
import static racingcar.exception.car.carName.LengthException.LENGTH_EXCEPTION_MESSAGE;
import static racingcar.exception.cars.DuplicateException.DUPLICATE_EXCEPTION_MESSAGE;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.utils.Parser;

public class ConstructorValidationTest {
    // 모델 생성자 테스트
    @ParameterizedTest
    @ValueSource(strings = {"a", "abc", "aca", "12345"})
    void 자동차_이름_올바른_입력_테스트(String carName) {
        assertThatCode(() -> new Car(carName))
                .doesNotThrowAnyException();
    }

    @Test
    void 자동차_이름_빈_문자열_테스트() {
        String carName = "";
        assertThatThrownBy(() -> new Car(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LENGTH_EXCEPTION_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"more_than_five", "abcdef", "123456", "아에이오우으", "!@#$%^"})
    void 자동차_이름_5자_이상인_경우(String carName) {
        assertThatThrownBy(() -> new Car(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LENGTH_EXCEPTION_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a,b,a", "succ,ess,fuln,ess"})
    void 자동차_이름_중복이_있는_경우(String carNames) {
        assertThatThrownBy(() -> {
            List<Car> carList = new ArrayList<>();
            Parser.parseWithComma(carNames)
                    .forEach(name -> carList.add(new Car(name)));
            new Cars(carList);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATE_EXCEPTION_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"공 백", "태\t앱"})
    void 자동차_이름_공백문자_있는_경우(String carName) {
        assertThatThrownBy(() -> new Car(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(HAS_SPACE_EXCEPTION_MESSAGE);
    }
}
