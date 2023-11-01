package racingcar.validator;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.constant.MessageConstant.*;

class ValidatorTest {

    @Test
    void 공백_입력_예외처리() {
        assertThatThrownBy(() -> Validator.validateCarNameInput(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CAR_NAME_INPUT_COUNT_ERROR.getMessage());
    }

    @Test
    void 이름에_대한_중복_예외처리() {
        assertThatThrownBy(() -> Validator.validateCarNameInput("pobi,pobi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CAR_NAME_INPUT_DUPLICATE_ERROR.getMessage());
    }

    @Test
    void 검증_후_리스트_반환_확인() {
        List<String> result = Validator.validateCarNameInput("pobi,woni");
        List<String> answer = List.of("pobi", "woni");
        assertThat(result).isEqualTo(answer);
    }

    @Test
    void 이름에_대한_예외처리_6자_이상_입력() {
        assertThatThrownBy(() -> Validator.validateCheckCarName("hg_yellow"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CAR_NAME_LENGTH_ERROR.getMessage());
    }

    @Test
    void 이름에_대한_예외처리_0자_입력() {
        assertThatThrownBy(() -> Validator.validateCheckCarName(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CAR_NAME_LENGTH_ERROR.getMessage());
    }

    @Test
    void 이름에_대한_예외처리_공백_포함() {
        assertThatThrownBy(() -> Validator.validateCheckCarName("pobi "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CAR_NAME_CONTAINS_SPACE_ERROR.getMessage());
    }

    @Test
    void 라운드에_대한_예외처리_0_입력() {
        assertThatThrownBy(() -> Validator.validateTotalTurnInput("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(TOTAL_ROUND_INPUT_ERROR.getMessage());
    }

    @Test
    void 라운드에_대한_예외처리_음수_입력() {
        assertThatThrownBy(() -> Validator.validateTotalTurnInput("-123"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(TOTAL_ROUND_INPUT_ERROR.getMessage());
    }

    @Test
    void 라운드에_대한_예외처리_알파벳_입력() {
        assertThatThrownBy(() -> Validator.validateTotalTurnInput("pobi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(TOTAL_ROUND_INPUT_ERROR.getMessage());
    }
}