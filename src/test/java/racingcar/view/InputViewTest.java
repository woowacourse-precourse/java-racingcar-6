package racingcar.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class InputViewTest {
    private InputView inputView = new InputView();
    private final InputStream standardIn = System.in;

    @AfterEach
    public void restoreSystemIn() {
        // System.in 값 복원
        System.setIn(standardIn);
    }

    @Test
    public void 입력값_String_이름_분리() {
        String input = "tobi,fobi,bobi";
        String[] result = input.split(",");

        Assertions.assertThat(result).contains("tobi", "fobi", "bobi");
    }

    @Test
    public void 입력값_System_In_이름_분리() {
        String input = "tobi,fobi,bobi";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        List<String> expected = Arrays.asList("tobi", "fobi", "bobi");
        List<String> actual = inputView.readCarsNamesInput();

        assertEquals(expected, actual);
    }
}
