package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.constant.ExceptionMessage;

class InputValidatorTest {

    @Test
    public void 이름은_빈_값일_수_없다() throws Exception{
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> InputValidator.validateCarsName(
                        new String[]{"", "name"}
                )).withMessage(ExceptionMessage.CAR_NAME_CANT_NOT_BLANK);
    }

    @Test
    public void 이름은_공백일_수_없다() throws Exception{
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> InputValidator.validateCarsName(
                        new String[]{" ", "name"}
                )).withMessage(ExceptionMessage.CAR_NAME_CANT_NOT_BLANK);
    }

    @Test
    public void 이름은_최대_5글자() throws Exception{
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> InputValidator.validateCarsName(
                        new String[]{"123456", "name"}
                )).withMessage(ExceptionMessage.CAR_NAME_IS_TOO_LONG);
    }

    @Test
    public void 중복된_이름_사용불가() throws Exception{
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> InputValidator.validateCarsName(
                        new String[]{"name", "name"}
                )).withMessage(ExceptionMessage.CAR_NAME_DUPLICATED);
    }

    @Test
    public void 정상_이름_사용() throws Exception{
        Assertions.assertThatNoException()
                .isThrownBy(() -> InputValidator.validateCarsName(
                        new String[]{"name1", "name2", "name3"}
                ));
    }

    @Test
    public void 라운드_횟수로_0은_사용될_수_없다() throws Exception{
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> InputValidator.validateRoundNumber("0"))
                .withMessage(ExceptionMessage.ROUND_NUMBER_MUST_POSITIVE);
    }

    @Test
    public void 라운드_횟수로_음수는_사용될_수_없다() throws Exception{
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> InputValidator.validateRoundNumber("-1"))
                .withMessage(ExceptionMessage.ROUND_NUMBER_MUST_POSITIVE);
    }

    @Test
    public void 라운드_횟수는_숫자가_입력되어야_한다() throws Exception{
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> InputValidator.validateRoundNumber("a"))
                .withMessage(ExceptionMessage.ROUND_NUMBER_MUST_BE_NUMBER);
    }

    @Test
    public void 라운드_횟수_정상_입력() throws Exception{
        Assertions.assertThatNoException()
                .isThrownBy(() -> InputValidator.validateRoundNumber("5"));
    }
}