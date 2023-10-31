package racingcar.view;

import static org.junit.jupiter.api.Assertions.*;
import static racingcar.view.InputView.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {

    InputView inputView = new InputView();

//    @BeforeEach
//    static void setUp() throws IOException {
//        InputStream in = new ByteArrayInputStream("".getBytes());
//        in.close();
//    }

    @DisplayName("자동차 이름 입력 테스트")
    @Test
    void testInputCarNames() throws IOException {
        String input = "car A, car B, car C";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        List<String> carNames = inputView.inputCarNames();
        in.close();
        assertEquals(List.of("car A", "car B", "car C"), carNames);
    }

    @DisplayName("자동차 이름은 쉼표(,)로 구분되어야 한다.")
    @Test
    void testValidateCarInput() {
        assertThrows(IllegalArgumentException.class, () -> inputView.validateCarInput("car1-car2-car3"));
    }

    @DisplayName("시도(이동) 횟수 입력은 숫자여야 한다.")
    @Test
    void testInputAttempNum() throws IOException {
//        String input = "1";
//        InputStream in = new ByteArrayInputStream(input.getBytes());
//        System.setIn(in);
//
//        int res = inputAttempNum();
//        assertThrows(IllegalArgumentException.class, ()->inputAttempNum());
    }
}