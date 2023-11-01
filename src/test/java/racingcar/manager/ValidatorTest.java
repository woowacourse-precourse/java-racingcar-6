package racingcar.manager;


import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.Test;
import static racingcar.Vars.LENGTH_CAR_NAME;

public class ValidatorTest {

    @Test
    void 이름의_길이_초과_예외_처리() {
        String longName = "verylongcarname";
        assertThatThrownBy(() -> Validator.validateCarNameLength(longName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LENGTH_CAR_NAME + "자 이하만 가능합니다.");
    }

    @Test
    void 이름이_공백인_경우_예외_처리() {
        String longName = " ";
        assertThatThrownBy(() -> Validator.validateCarNameLength(longName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름의 길이는 1~" + LENGTH_CAR_NAME + "자만 가능합니다.");
    }

    @Test
    void 이름_중복_입력_예외_처리() {
        String[] duplicateNames = {"pobi", "pobi", "javaji"};
        assertThatThrownBy(() -> Validator.validateNoDuplicateNames(duplicateNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 이름이 있습니다.");
    }

    @Test
    void RaceRoundInput_숫자가_아닌_경우_예외_처리() {
        assertThatThrownBy(() -> Validator.validateRaceRoundInput("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("레이스 라운드는 숫자만 입력 가능합니다.");
    }

    @Test
    void RaceRoundInput_0_이하의_숫자가_입력된_경우_에외_처리() {
        assertThatThrownBy(() -> Validator.validateRaceRoundInput("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("레이스 라운드는 양의 정수만 가능합니다.");

        assertThatThrownBy(() -> Validator.validateRaceRoundInput("-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("레이스 라운드는 양의 정수만 가능합니다.");
    }
}
