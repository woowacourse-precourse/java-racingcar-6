package racingcar.validation;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.ThrowableAssert.catchThrowable;

import org.junit.jupiter.api.Test;

class InputValidationTest {

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
            InputValidation.NameLength(case1);
        });
        Throwable result2 = catchThrowable(() -> {
            InputValidation.NameLength(case2);
        });
        Throwable result3 = catchThrowable(() -> {
            InputValidation.NameLength(case3);
        });
        Throwable result4 = catchThrowable(() -> {
            InputValidation.NameLength(case4);
        });
        Throwable result5 = catchThrowable(() -> {
            InputValidation.NameLength(case5);
        });

        // then
        assertThat(result1).as("length 5").doesNotThrowAnyException();
        assertThat(result2).as("length 4").doesNotThrowAnyException();
        assertThat(result3).as("length 6").isInstanceOf(IllegalArgumentException.class);
        assertThat(result4).as("length 5 with space").doesNotThrowAnyException();
        assertThat(result5).as("length 5 with space").doesNotThrowAnyException();
    }
}