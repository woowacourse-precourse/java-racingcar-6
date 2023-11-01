package racingcar.utils;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.*;

class ValidatorTest {
    private Validator validator;

    @BeforeEach
    void SetUp() {
        validator = new Validator();
    }

    @DisplayName("자동차 이름은 5글자를 초과할 수 없다.")
    @Test
    void 자동차_이름_길이초과_예외_테스트() {
        String name = "jun111";
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름은 공백일 수 없다.")
    @Test
    void 자동차_이름_공백_예외_테스트() {
        String name = "";
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("시도 회수는 0 이상의 정수이어야한다.")
    @Test
    void 시도회수_예외_테스트() {
        int trial = -1;
        assertThatThrownBy(() -> validator.validateTrial(trial))
                .isInstanceOf(IllegalArgumentException.class);
    }
}