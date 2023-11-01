package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;



class InputValuesTest {
    InputValues values = new InputValues();

    @Test
    void getName() {
        String test = "test";
        System.setIn(new ByteArrayInputStream(test.getBytes()));

        Assertions.assertThat(values.getName()).isEqualTo(test);
    }

    @Test
    void getCount() {
        String test = "123";
        System.setIn(new ByteArrayInputStream(test.getBytes()));

        Assertions.assertThat(values.getCount()).isEqualTo(test);
    }
}