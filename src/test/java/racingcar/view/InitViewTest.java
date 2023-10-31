package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.util.InputValidatior;

class InitViewTest {
    private static InitView initView;

    @BeforeAll
    static void initAll() {
        InputValidatior inputValidatior = new InputValidatior();
        initView = new InitView(inputValidatior);
    }

    @AfterEach
    void afterEach() {
        System.out.flush();
    }

    @Test
    void inputCarNames_split_기능_테스트() {
        initInputStream("1,2,3");
        String[] result = initView.inputCarNames();

        assertThat(result).contains("2", "1", "3");
        assertThat(result).containsExactly("1", "2", "3");
    }

    @Test
    void inputCarNames_split_기능_예외_테스트() {
        initInputStream("1,2, 356");

        String[] result = initView.inputCarNames();

        assertThatThrownBy(() ->
                assertThat(result).containsExactly("1", "2", "3")
                        .isInstanceOf(AssertionError.class));
    }

    @Test
    void inputTryNumber_기능_테스트() {
        initInputStream("14");
        int tryNumber = initView.inputTryNumber();

        assertThat(tryNumber).isEqualTo(14);
    }

    @Test
    void inputTryNumber_기능_예외_테스트() {
        initInputStream("abc");

        int tryNumber = initView.inputTryNumber();

        assertThatThrownBy(() -> {
            assertThat(tryNumber).isEqualTo(4).isInstanceOf(IllegalArgumentException.class);
        });
    }

    private static void initInputStream(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }
}