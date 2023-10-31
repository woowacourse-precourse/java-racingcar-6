package view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import racingcar.util.InputValidatior;
import racingcar.view.InitView;

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
        setInputStream("1,2,3");
        String[] input = initView.inputCarNames();
        assertThat(input).containsExactly("1", "2", "3");
    }

    @Test
    void inputCarNames_split_기능_예외_테스트() {
        setInputStream("1,2, 356");
        assertThatThrownBy(() -> {
            assertThat(initView.inputCarNames())
                    .isInstanceOf(AssertionError.class);
        });
    }

    @Test
    void 입력한_자동차_이름_길이가_5를_넘지_않는_경우_테스트() {
        setInputStream("car1,car2,car3");
        String[] input = initView.inputCarNames();

        assertThat(input).containsExactly("car1", "car2", "car3");

    }

    @Test
    void 입력한_자동차_이름_길이가_5를_넘는_경우_예외_테스트() {
        setInputStream("car123,      car2,car3      ");

        assertThatThrownBy(
                () -> {
                    assertThat(initView.inputCarNames())
                            .isInstanceOf(IllegalArgumentException.class);
                });
    }

    @Test
    void inputTryNumber_기능_테스트() {
        setInputStream("1");

        int tryNumber = initView.inputTryNumber();
        assertThat(tryNumber).isEqualTo(1);

    }

    @Test
    void inputTryNumber_기능_예외_테스트() {
        setInputStream("");
        assertThatThrownBy(() -> {
            initView.inputTryNumber();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    private void setInputStream(String input) {
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }
}