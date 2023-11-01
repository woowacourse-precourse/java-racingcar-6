package racingcar.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InputValidationTest {

    private List<String> carNames;

    @Test
    void 시도수_정상_입력_테스트() {
        InputValidation.validateTriesInput("3");
    }

    @Test
    void 시도수_빈_입력_예외_확인() {
        assertThatThrownBy(() -> InputValidation.validateTriesInput(""))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("값을 입력해주세요");
    }

    @Test
    void 시도수_숫자가_아닌_입력_예외_확인() {
        assertThatThrownBy(() -> InputValidation.validateTriesInput("string"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("정수를 입력해주세요");
    }

    @Test
    void 시도수_범위_밖_숫자_입력_예외_확인() {
        assertThatThrownBy(() -> InputValidation.validateTriesInput(" 2147483648"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("정수를 입력해주세요");
    }

    @BeforeEach
    void setNameList() {
        carNames = new ArrayList<>();
        carNames.add("pobi");
    }

    @Test
    void 이름_정상_입력_테스트() {
        carNames.add("woni");
        InputValidation.validateCarNamesInput(carNames);
    }

    @Test
    void 이름_빈_입력_예외_확인() {
        carNames.add("");
        assertThatThrownBy(() -> InputValidation.validateCarNamesInput(carNames))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("값을 입력해주세요");
    }

    @Test
    void 이름_중복_입력_예외_확인() {
        carNames.add("pobi");
        assertThatThrownBy(() -> InputValidation.validateCarNamesInput(carNames))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("중복되지 않은 이름을 입력해주세요");
    }

    @Test
    void 이름_길이_초과_예외_확인() {
        carNames.add("phillips");
        assertThatThrownBy(() -> InputValidation.validateCarNamesInput(carNames))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("5자 이하의 이름을 입력해주세요");
    }

    @Test
    void 이름_입력_개수_예외_확인() {
        assertThatThrownBy(() -> InputValidation.validateCarNamesInput(carNames))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("2개 이상의 자동차 이름을 입력해주세요");
        ;
    }

}