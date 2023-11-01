package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import racingcar.validation.Validation;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

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

    @Test
    void 문자열의_길이가_5이하면_통과() {
        //given
        String case1 = "onetwothree";
        String case2 = "one";

        //when
        Throwable result1 = catchThrowable(()->{
            Validation.validateCarNameLength(case1);
        });
        Throwable result2 = catchThrowable(()->{
            Validation.validateCarNameLength(case2);
        });

        //then
        assertThat(result1).isInstanceOf(IllegalArgumentException.class);
        assertThat(result2).doesNotThrowAnyException();
    }

    @Test
    void 현재_키셋안에_중복된_이름이_없으면_통과() {
        final HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("one", "--"); hashMap.put("two", "---");
        //given
        String case1 = "three";
        String case2 = "one";

        //when
        Throwable result1 = catchThrowable(()->{
            Validation.validateCarNamesNotDuplicate(hashMap, case1);
        });
        Throwable result2 = catchThrowable(()->{
            Validation.validateCarNamesNotDuplicate(hashMap, case2);
        });

        //then
        assertThat(result1).doesNotThrowAnyException();
        assertThat(result2).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자로만_이루어져있으면_통과() {
        //given
        String case1 = "5";
        String case2 = "-1";
        String case3 = " 3 ";

        //when
        Throwable result1 = catchThrowable(()->{
            Validation.validateIsDigit(case1);
        });
        Throwable result2 = catchThrowable(()->{
            Validation.validateIsDigit(case2);
        });
        Throwable result3 = catchThrowable(()->{
            Validation.validateIsDigit(case3);
        });

        //then
        assertThat(result1).doesNotThrowAnyException();
        assertThat(result2).doesNotThrowAnyException();
        assertThat(result3).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도횟수가_0이상이면_통과() {
        final HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("one", "--"); hashMap.put("two", "---");
        //given
        String case1 = "2";
        String case2 = "-1";

        //when
        Throwable result1 = catchThrowable(()->{
            Validation.validateTryNumber(case1);
        });
        Throwable result2 = catchThrowable(()->{
            Validation.validateTryNumber(case2);
        });

        //then
        assertThat(result1).doesNotThrowAnyException();
        assertThat(result2).isInstanceOf(IllegalArgumentException.class);
    }

}
