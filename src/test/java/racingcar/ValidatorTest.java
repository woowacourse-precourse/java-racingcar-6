package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.validator.Validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidatorTest {
    Validator validator = new Validator();
    @Test
    public void 차이름예외처리_글자제한_TEST() throws Exception{
        String input = "pobiii,dddd";
        assertThatThrownBy(()->validator.checkCarNameInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("차이름은 5글자 제한입니다.");
    }

    @Test
    public void 차이름예외처리_중복처리_TEST() throws Exception{
        String input = "pobi,pobi";
        assertThatThrownBy(()->validator.checkCarNameInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("차이름이 중복입니다.");
    }

    @Test
    public void 차이름예외처리_이름끝에콤마_TEST() throws Exception{
        String input = "pobi,";
        assertThatThrownBy(()->validator.checkCarNameInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("콤마로 끝나는 이름이 있습니다.");
    }

    @Test
    public void 차이름예외처리_공백포함_TEST() throws Exception{
        String input = "pobi, dfdf";
        assertThatThrownBy(()->validator.checkCarNameInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("차이름에 공백이 포함되어 있습니다.");
    }

    @Test
    public void 시도횟수예외처리_빈문자입력_TEST() throws Exception{
        String input = "";
        assertThatThrownBy(()->validator.checkAttemptNumInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력이 없습니다.");
    }

    @Test
    public void 시도횟수예외처리_숫자가아닌경우_TEST() throws Exception{
        String input = "abc";
        assertThatThrownBy(()->validator.checkAttemptNumInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자가 아닌 문자가 입력되었습니다.");
    }
}
