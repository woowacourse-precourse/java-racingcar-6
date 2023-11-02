package racingcar.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest {


    @Test
    public void testGetCarNameEmpty() {
        System.setIn(new ByteArrayInputStream("".getBytes()));
        assertThatThrownBy(InputView::getCarName)
                .isInstanceOf(IllegalArgumentException.class);
    }


    @ParameterizedTest
    @ValueSource(strings = {"", "abcdef", "2147483648"})
    public void testGetTryNumber(String number) {
        System.setIn(new ByteArrayInputStream(number.getBytes()));
        assertThatThrownBy(InputView::getTryNumber)
                .isInstanceOf(IllegalArgumentException.class);
    }

}