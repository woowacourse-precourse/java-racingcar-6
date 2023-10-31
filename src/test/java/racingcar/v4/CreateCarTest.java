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
        List<String> carNames = Arrays.asList("벤츠", "페라리", "레드불");
        createCar.validateCarNameLength(carNames);
    }

    @Test
    void 자동차_이름이_6자_이상인_경우_예외가_발생한다() {
        CreateCar createCar = new CreateCar();
        List<String> carNames = Arrays.asList("메르세데스벤츠", "페라리", "레드불");
        assertThatThrownBy(() -> createCar.validateCarNameLength(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하만 가능합니다.");
    }

    @Test
    void 자동차_이름이_중복되지_않은_경우_예외가_발생하지_않는다() {
        CreateCar createCar = new CreateCar();
        List<String> carNames = Arrays.asList("페라리", "벤츠", "레드불");
        createCar.validateCarNameDuplicate(carNames);
    }

    @Test
    void 자동차_이름이_중복된_경우_예외가_발생한다() {
        CreateCar createCar = new CreateCar();
        List<String> carNames = Arrays.asList("페라리", "페라리", "레드불");
        assertThatThrownBy(() -> createCar.validateCarNameDuplicate(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 이름이 존재합니다.");
    }

    @Test
    void 자동차_수가_2대_이상_10대_이하인_경우_예외가_발생하지_않는다() {
        CreateCar createCar = new CreateCar();
        List<String> carNames = Arrays.asList("페라리", "벤츠", "레드불", "맥라린", "BWT", "윌리엄스", "하스", "에스턴마틴", "알파로메오", "현다이");
        createCar.validateCarCount(carNames);
    }

    @Test
    void 자동차_수가_1대인_경우_예외가_발생한다() {
        CreateCar createCar = new CreateCar();
        List<String> carNames = Arrays.asList("페라리");
        assertThatThrownBy(() -> createCar.validateCarCount(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차의 수는 2대 이상 10대 이하만 가능합니다.");
    }

    @Test
    void 자동차_수가_11대인_경우_예외가_발생한다() {
        CreateCar createCar = new CreateCar();
        List<String> carNames = Arrays.asList("페라리", "벤츠", "레드불", "맥라린", "BWT", "윌리엄스", "하스", "에스턴마틴", "알파로메오", "현다이", "기아");
        assertThatThrownBy(() -> createCar.validateCarCount(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차의 수는 2대 이상 10대 이하만 가능합니다.");
    }


}