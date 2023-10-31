package racingcar.service;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SaveInputValueTest {

    @Test
    void 자동차_이름_중복되면_예외_발생() {
        List<String> cars = new ArrayList<>(List.of("cars1", "cars2", "cars1"));
        SaveInputValue saveInputValue = new SaveInputValue(cars, null);
        assertThatThrownBy(saveInputValue::isCarNameDuplicated)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름_입력값_하나면_예외_발생() {
        List<String> cars = new ArrayList<>(List.of("car"));
        SaveInputValue saveInputValue = new SaveInputValue(cars, null);
        assertThatThrownBy(saveInputValue::isCarNameJustOne)
                .isInstanceOf(IllegalArgumentException.class);
    }
}