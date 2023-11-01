package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.controller.Validation;
import racingcar.model.Car;

public class InputTest {
    @Test
    void 이름_입력안한_경우_처리() {
        Car car = new Car(Collections.emptyList());
        assertThatThrownBy(() -> Validation.validateEmtpy())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름_길이_예외_처리() {
        Car car = new Car(List.of("abc", "cde", "abcdef"));
        assertThatThrownBy(() -> Validation.validateLength())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름_중복_예외_처리() {
        Car car = new Car(List.of("Abc", "abc"));
        assertThatThrownBy(() -> Validation.validateDuplicate())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름_알파벳_이외_문자_예외_처리() {
        Car car = new Car(List.of("abd", "qAz", "aq1"));

        assertThatThrownBy(() -> Validation.validateCharacters())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도_횟수_예외_처리() {
        int input = 0;

        assertThatThrownBy(() -> Validation.validateOneToNine(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
