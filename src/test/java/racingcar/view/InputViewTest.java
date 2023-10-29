package racingcar.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Nested;
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
    public void 차이름_입력값_String_이름_분리() {
        String input = "tobi,fobi,bobi";
        String[] result = input.split(",");

        Assertions.assertThat(result).contains("tobi", "fobi", "bobi");
    }

    @Test
    public void 차이름_입력값_이름_분리() {
        String input = "tobi,fobi,bobi";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        List<String> expected = Arrays.asList("tobi", "fobi", "bobi");
        List<String> actual = inputView.readCarsNamesInput();

        assertEquals(expected, actual);
    }

    @Nested
    class 실행횟수_입력값 {
        @Test
        public void 실행횟수_입력값_숫자형식예외_글자() {
            String input = "errorValue";
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);

            Assertions.assertThatThrownBy(() -> inputView.readNumberInput())
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        public void 실행횟수_입력값_숫자형식예외_int범위외() {
            String input = "2147483648";
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);

            Assertions.assertThatThrownBy(() -> inputView.readNumberInput())
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        public void 실행횟수_입력값_숫자형식예외_음수() {
            String input = "-3";
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);

            Assertions.assertThatThrownBy(() -> inputView.readNumberInput())
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        public void 실행횟수_입력값_빈값예외() {
            String input = "";
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);

            Assertions.assertThatThrownBy(() -> inputView.readNumberInput())
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
