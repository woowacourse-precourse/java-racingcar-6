package racingcar.v4;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


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
    void 입력값에_쉼표가_없는_경우_예외가_발생한다() {
        CreateCar createCar = new CreateCar();
        assertThatThrownBy(() -> createCar.splitCarNames("페라리 벤츠"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름을 쉼표로 구분해주세요.");
    }

    @Test
    void 자동차_이름을_쉼표로_구분하여_리스트로_변환한다() {
        CreateCar createCar = new CreateCar();
        List<String> carNames = createCar.splitCarNames("벤츠,페라리,레드불");
        assertThat(carNames).containsExactly("벤츠", "페라리", "레드불");
    }

    @Test
    void 자동차_이름을_공백으로_구분하여_리스트로_변환한다() {
        CreateCar createCar = new CreateCar();
        List<String> carNames = Arrays.asList(" 벤츠 ", " 페라리 ", " 레드불 ");
        List<String> trimmedCarNames = createCar.trimCarNames(carNames);
        assertThat(trimmedCarNames).containsExactly("벤츠", "페라리", "레드불");
    }

    @Test
    void 자동차_이름이_5자_이하인_경우_예외가_발생하지_않는다() {
        CreateCar createCar = new CreateCar();
        List<String> carNames = Arrays.asList("pobi", "crong", "honux");
        createCar.validateCarNameLength(carNames);
    }

    @Test
    void 자동차_이름이_6자_이상인_경우_예외가_발생한다() {
        CreateCar createCar = new CreateCar();
        List<String> carNames = Arrays.asList("pobipobi", "crong", "honux");
        assertThatThrownBy(() -> createCar.validateCarNameLength(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하만 가능합니다.");
    }



}