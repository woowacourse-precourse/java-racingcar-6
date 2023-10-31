package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import racingcar.validation.Validation;
import org.junit.jupiter.api.Test;

public class ValidationTest {
    @Test
    void 입력받은_문자열이_null이_아니면_통과() {
        //given
        String case1 = "붕붕이";
        String case2 = "   ";
        String case3 = null;
        String case4 = " , , , ";

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
        Throwable result4 = catchThrowable(()->{
            Validation.validateIsNotNull(case4);
        });

        //then
        assertThat(result1).doesNotThrowAnyException();
        assertThat(result2).isInstanceOf(IllegalArgumentException.class);
        assertThat(result3).isInstanceOf(IllegalArgumentException.class);
        assertThat(result4).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 콤마_1개로만_이름의_구분이_가능하면_통과() {
        //given
        String case1 = "one,two,three";
        String case2 = "one1,two2,three3";
        String case3 = "one, two, three";

        //when
        Throwable result1 = catchThrowable(()->{
            Validation.validateSeparator(case1);
        });
        Throwable result2 = catchThrowable(()->{
            Validation.validateSeparator(case2);
        });
        Throwable result3 = catchThrowable(()->{
            Validation.validateSeparator(case3);
        });

        //then
        assertThat(result1).doesNotThrowAnyException();
        assertThat(result2).doesNotThrowAnyException();
        assertThat(result3).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 배열의_길이가_1이상이면_통과() {
        //given
        String[] case1 = {"one,two,three"};
        String[] case2 = {"one"};
        String[] case3 = {};

        //when
        Throwable result1 = catchThrowable(()->{
            Validation.validateCarNumber(case1);
        });
        Throwable result2 = catchThrowable(()->{
            Validation.validateCarNumber(case2);
        });
        Throwable result3 = catchThrowable(()->{
            Validation.validateCarNumber(case3);
        });

        //then
        assertThat(result1).doesNotThrowAnyException();
        assertThat(result2).doesNotThrowAnyException();
        assertThat(result3).isInstanceOf(IllegalArgumentException.class);
    }

}
