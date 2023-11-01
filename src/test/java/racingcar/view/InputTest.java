package racingcar.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InputTest {

    private Input input;

    @BeforeEach
    public void setUp() {
        input = new Input();
    }


    @Test
    public void testNumberTimesTryWithInvalidInput() {

        String inputString = "0";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(inputStream);

        assertThatThrownBy(() -> input.numberTimesTry())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도할 회수의 범위는 1 ~ 2_147_483_646 입니다.");
    }
}
