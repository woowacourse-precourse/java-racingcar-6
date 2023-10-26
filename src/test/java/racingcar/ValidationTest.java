package racingcar;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.ThrowableAssert.catchThrowable;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

class ValidationTest {

    @Test
    void duplication() {
        // given
        List<String> stringList = new ArrayList<>();
        stringList.add("name1");
        String case1 = "name1";
        String case2 = "name2";

        // when
        Throwable result1 = catchThrowable(() -> {
            Validation.duplication(stringList, case1);
        });
        Throwable result2 = catchThrowable(() -> {
            Validation.duplication(stringList, case2);
        });

        // then
        assertThat(result1).as("duplicate").isInstanceOf(IllegalArgumentException.class);
        assertThat(result2).as("non duplicate").doesNotThrowAnyException();
    }

    @Test
    void empty() {
        // given
        List<Car> case1 = List.of(new Car("car1", 1));
        List<Car> case2 = List.of();

        // when
        Throwable result1 = catchThrowable(() -> {
            Validation.empty(case1);
        });
        Throwable result2 = catchThrowable(() -> {
            Validation.empty(case2);
        });

        // then
        assertThat(result1).as("1 car").doesNotThrowAnyException();
        assertThat(result2).as("no car").isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isNumber() {
        // given
        String case1 = "1";
        String case2 = "12";
        String case3 = "-1";
        String case4 = "a";

        // when
        Throwable result1 = catchThrowable(() -> {
            Validation.isNumber(case1);
        });
        Throwable result2 = catchThrowable(() -> {
            Validation.isNumber(case2);
        });
        Throwable result3 = catchThrowable(() -> {
            Validation.isNumber(case3);
        });
        Throwable result4 = catchThrowable(() -> {
            Validation.isNumber(case4);
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
            Validation.nameLength(case1);
        });
        Throwable result2 = catchThrowable(() -> {
            Validation.nameLength(case2);
        });
        Throwable result3 = catchThrowable(() -> {
            Validation.nameLength(case3);
        });
        Throwable result4 = catchThrowable(() -> {
            Validation.nameLength(case4);
        });
        Throwable result5 = catchThrowable(() -> {
            Validation.nameLength(case5);
        });

        // then
        assertThat(result1).as("length 5").doesNotThrowAnyException();
        assertThat(result2).as("length 4").doesNotThrowAnyException();
        assertThat(result3).as("length 6").isInstanceOf(IllegalArgumentException.class);
        assertThat(result4).as("length 5 with space").doesNotThrowAnyException();
        assertThat(result5).as("length 5 with space").doesNotThrowAnyException();
    }
}