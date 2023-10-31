package racingcar.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class TryNumValidatorTest {
    private TryNumValidator tryNumValidator;

    @BeforeEach
    void setUp() {
        tryNumValidator = new TryNumValidator();
    }

    // 이동 횟수가 수가 아닌 문자인 경우

    @Test
    @DisplayName("이동횟수가 문자가 들어온 경우")
    void 이동횟수가_문자인_경우() throws Exception {
        //given
        String tryNum = "one";
        //when
        //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> tryNumValidator.validate(tryNum))
                .withMessage(ErrorMessage.TRY_NUM_NOT_NUMBER_ERROR.getErrorMessage());
    }

    @Test
    @DisplayName("이동횟수가 0인 경우")
    void 이동횟수가_0인_경우() throws Exception {
        //given
        String tryNum = "0";
        //when
        //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> tryNumValidator.validate(tryNum))
                .withMessage(ErrorMessage.TRY_NUM_IS_ZERO_ERROR.getErrorMessage());
    }
}