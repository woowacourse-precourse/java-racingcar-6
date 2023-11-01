package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputTest {
    Input input;

    @BeforeEach
    public void beforeEach() {
        input = new Input();
    }

    @AfterEach
    public void afterEach() {
        Console.close();
    }

    @Test
    void enterCarName() {
        //given
        String testString = "abc,def,ghi";
        ByteArrayInputStream testStream = new ByteArrayInputStream(testString.getBytes());
        System.setIn(testStream);
        //when
        String result = input.enterCarName();
        //then
        Assertions.assertThat(result).isEqualTo(testString);
    }

    @Test
    void enterAttemptNum() {
        //given
        String testString = "10";
        ByteArrayInputStream testStream = new ByteArrayInputStream(testString.getBytes());
        System.setIn(testStream);
        //when
        String result = input.enterCarName();
        //then
        Assertions.assertThat(result).isEqualTo(testString);
    }
}