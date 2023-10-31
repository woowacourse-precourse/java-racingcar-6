package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import racingcar.validation.Validation;
import org.junit.jupiter.api.Test;
import java.util.List;

public class ValidationTest {
    @Test
    void 입력받은_문자열이_null이_아니면_통과() {
        //given
        String case1 = "붕붕이";
        String case2 = "   ";
        String case3 = null;

        //when
        Throwable result1 = catchThrowable(()->{
            Validation.validateIsNotNull(case1);
        });
        Throwable result2 = catchThrowable(()->{
            Validation.validateIsNotNull(case2);
        });
        Throwable result3 = catchThrowable(()->{
            Validation.validateIsNotNull(case3);
        });

        //then
        assertThat(result1).doesNotThrowAnyException();
        assertThat(result2).isInstanceOf(IllegalArgumentException.class);
        assertThat(result3).isInstanceOf(IllegalArgumentException.class);
    }

}
