package racingcar.validator;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.exception.car.name.LengthException.LENGTH_EXCEPTION_MESSAGE;
import static racingcar.exception.cars.DuplicateException.DUPLICATE_EXCEPTION_MESSAGE;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.utils.Parser;

public class ModelValidatorTest {
    // 모델 생성자 테스트
    @ParameterizedTest
    @ValueSource(strings = {"a", "abc", "aca", "12345"})
    void 자동차_이름_올바른_입력_테스트(String carName) {
        assertThatCode(() -> new Car(carName))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "more_than_five", "abcdef", "123456", "아에이오우으"})
    void 자동차_이름_1자_이상_5자_이하가_아닌_경우(String carName) {
        assertThatThrownBy(() -> new Car(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LENGTH_EXCEPTION_MESSAGE);
    }

    @Test
    void 자동차_이름_중복이_있는_경우() {
        assertThatThrownBy(() -> {
            List<Car> carList = new ArrayList<>();
            String carNames = "succ,ess,ful,ess";
            Parser.parseWithComma(carNames)
                    .forEach(name -> carList.add(new Car(name)));
            new Cars(carList);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATE_EXCEPTION_MESSAGE);
    }
}
