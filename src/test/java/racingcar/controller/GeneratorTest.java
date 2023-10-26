package racingcar.controller;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.controller.Generator;
import racingcar.model.Car;

class GeneratorTest {

    @Test
    void carList() {
        // given
        String case1 = "1,2,3,4";
        String case2 = "12345,asdfg";
        String case3 = ",";
        String case4 = "asdfg,zxcvzxcvzxv";

        // when
        List<Car> result1 = Generator.carList(case1);
        List<Car> result2 = Generator.carList(case2);
        Throwable result3 = catchThrowable(() -> {
            Generator.carList(case3);
        });
        Throwable result4 = catchThrowable(() -> {
            Generator.carList(case4);
        });

        // then
        assertThat(result1.size()).as("4 cars").isEqualTo(4);
        assertThat(result2.size()).as("2 cars").isEqualTo(2);
        assertThat(result3).as("error with no car").isInstanceOf(IllegalArgumentException.class);
        assertThat(result4).as("error with name length").isInstanceOf(IllegalArgumentException.class);
    }
}