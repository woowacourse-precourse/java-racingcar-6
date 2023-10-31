package racingcar.domain.validator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ValidatorTest {

    @Test
    void 자동차_이름_5자이상_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Validator.carName(List.of("pobipobi", "pobi")))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("자동차 이름은 5자 이하여야 합니다.")
        );
    }

    @Test
    void 자동차_이름_0자_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Validator.carName(List.of("", "pobi")))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("자동차 이름은 1자 이상이어야 합니다.")
        );
    }

    @Test
    void 자동차_이름_공백_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Validator.carName(List.of(" ")))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("자동차 이름은 1자 이상이어야 합니다.")
        );
    }

    @Test
    void 자동차_이름_빈값_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Validator.carName(new ArrayList<>()))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("자동차 이름을 입력해야 합니다.")
        );
    }

    @Test
    void 자동차_이동횟수_0이하_예외_처리_1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Validator.moveNumber(0))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("1이상의 숫자를 입력해야합니다.")
        );
    }

    @Test
    void 자동차_이동횟수_0이하_예외_처리_2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Validator.moveNumber(-1))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("1이상의 숫자를 입력해야합니다.")
        );
    }
}
