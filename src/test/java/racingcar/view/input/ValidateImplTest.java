package racingcar.view.input;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

class ValidateImplTest {

    Validator validator = new ValidateImpl();

    @Test
    public void 이름이_5글자_이하라면_정상처리() throws Exception {
        //given
        String name = "pobia";

        //when
        Throwable throwable = catchThrowable(() -> validator.validateCarName(name));

        //then
        assertThat(throwable).isNull();
    }

    @Test
    public void 이름이_5글자보다_크다면_예외발생() throws Exception {
        //given
        String name = "pobiaa";

        //when
        Throwable throwable = catchThrowable(() -> validator.validateCarName(name));

        //then
        assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
    }
}