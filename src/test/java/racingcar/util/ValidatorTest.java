package racingcar.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ValidatorTest {

    @Test
    @DisplayName("공백을 입력했을때에 대한 테스트")
    void 공백_입력_예외처리_테스트() throws Exception {
        //given
        String inputCarName = "";
        //when
        //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Validator.validateEmptyInput(inputCarName))
                .withMessage(ErrorMessage.EMPTY_INPUT_ERROR.getErrorMessage());
    }
}