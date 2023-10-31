package racingcar.v4;


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

    @Test
    void 자동차_이름이_null인_경우_예외가_발생한다() {
        CreateCar createCar = new CreateCar();
        assertThatThrownBy(() -> createCar.validateCarNameNotEmpty(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 1자 이상이어야 합니다.");
    }

    @Test
    void 자동차_이름이_공백만_있는_경우_예외가_발생한다() {
        CreateCar createCar = new CreateCar();
        assertThatThrownBy(() -> createCar.validateCarNameNotEmpty("    "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 1자 이상이어야 합니다.");
    }

    @Test
    void 자동차_이름에_쉼표가_없는_경우_예외가_발생한다() {
        CreateCar createCar = new CreateCar();
        assertThatThrownBy(() -> createCar.splitCarNames("페라리 벤츠"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름을 쉼표로 구분해주세요.");
    }

}