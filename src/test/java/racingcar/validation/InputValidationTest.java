package racingcar.validation;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.ThrowableAssert.catchThrowable;

import org.junit.jupiter.api.Test;

class InputValidationTest {

    @Test
    void isNumber() {
        // given
        String case1 = "1";
        String case2 = "12";
        String case3 = "-1";
        String case4 = "a";

        // when
        Throwable result1 = catchThrowable(() -> {
            InputValidation.isNumber(case1);
        });
        Throwable result2 = catchThrowable(() -> {
            InputValidation.isNumber(case2);
        });
        Throwable result3 = catchThrowable(() -> {
            InputValidation.isNumber(case3);
        });
        Throwable result4 = catchThrowable(() -> {
            InputValidation.isNumber(case4);
        });

        // then
        assertThat(result1).as("1").doesNotThrowAnyException();
        assertThat(result2).as("12").doesNotThrowAnyException();
        assertThat(result3).as("-1").isInstanceOf(IllegalArgumentException.class);
        assertThat(result4).as("a").isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void nameLength() {
        // given
        String case1 = "12345";
        String case2 = "1234";
        String case3 = "asdfgj";
        String case4 = "asdf ";
        String case5 = " asdf";

        // when
        Throwable result1 = catchThrowable(() -> {
            InputValidation.nameLength(case1);
        });
        Throwable result2 = catchThrowable(() -> {
            InputValidation.nameLength(case2);
        });
        Throwable result3 = catchThrowable(() -> {
            InputValidation.nameLength(case3);
        });
        Throwable result4 = catchThrowable(() -> {
            InputValidation.nameLength(case4);
        });
        Throwable result5 = catchThrowable(() -> {
            InputValidation.nameLength(case5);
        });

        // then
        assertThat(result1).as("length 5").doesNotThrowAnyException();
        assertThat(result2).as("length 4").doesNotThrowAnyException();
        assertThat(result3).as("length 6").isInstanceOf(IllegalArgumentException.class);
        assertThat(result4).as("length 5 with space").doesNotThrowAnyException();
        assertThat(result5).as("length 5 with space").doesNotThrowAnyException();
    }
}