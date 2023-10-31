package racingcar.v4;


import org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;


class CreateCarTest {

    @Test
    void 자동차_이름이_비어있는_경우_예외가_발생한다() {
        CreateCar createCar = new CreateCar();
        assertThatThrownBy(() -> createCar.validateCarNameNotEmpty(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 1자 이상이어야 합니다.");
    }

}