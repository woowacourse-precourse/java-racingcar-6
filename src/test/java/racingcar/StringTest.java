package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import racingcar.validator.InputValidator;
import racingcar.view.InputView;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StringTest {

    private InputStream originalSystemIn;

    @BeforeEach
    public void setUp() {
        originalSystemIn = System.in;
    }

    @AfterEach
    public void reset() {
        System.setIn(originalSystemIn);
    }


    @Test
    @Order(1)
    @DisplayName("쉼표를 사용해 여러개의 차를 입력하는 경우 확인")
    public void inputCarNames_withSeperator() {
        String input = "pobi,woni";
        boolean result = InputValidator.isValidCarName(input);
        assertThat(result).isEqualTo(true);
    }

    @Test
    @Order(2)
    @DisplayName("하나의 차만 생성하는 경우 확인")
    public void inputCarNames_withOneCar() {
        ByteArrayInputStream in = new ByteArrayInputStream("pobi".getBytes());
        System.setIn(in);

        List<String> result = InputView.inputCarNames();
        assertThat(result).containsExactly("pobi");
    }

    @Test
    @Order(3)
    @DisplayName("차의 이름으로 공백이 입력된 경우 확인")
    public void inputCarNames_withEmptyString() {
        ByteArrayInputStream in = new ByteArrayInputStream("".getBytes());
        System.setIn(in);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            List<String> result = InputView.inputCarNames();
        });
    }

    @Test
    @Order(4)
    @DisplayName("차의 이름 길이가 너무 긴 경우(5자 초과) 확인")
    public void inputCarNames_withTooLongCarName() {
        ByteArrayInputStream in = new ByteArrayInputStream("pobbiii,wuni".getBytes());
        System.setIn(in);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            List<String> result = InputView.inputCarNames();
        });
    }

    @Test
    @Order(5)
    @DisplayName("빈 문자가 입력되는 경우 확인")
    public void inputAttempts_withEmptyString() {
        ByteArrayInputStream in = new ByteArrayInputStream("".getBytes());
        System.setIn(in);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            int result = InputView.inputAttempts();
        });
    }

    @Test
    @Order(6)
    @DisplayName("음수가 입력된 경우 확인")

    public void inputAttempts_withInvalidNumber() {
        ByteArrayInputStream in = new ByteArrayInputStream("-1".getBytes());
        System.setIn(in);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            int result = InputView.inputAttempts();
        });
    }

    @Test
    @Order(7)
    @DisplayName("숫자가 아닌 문자가 입력될 경우 확인")
    public void inputAttempts() {
        ByteArrayInputStream in = new ByteArrayInputStream("a".getBytes());
        System.setIn(in);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            int result = InputView.inputAttempts();
        });
    }


}
