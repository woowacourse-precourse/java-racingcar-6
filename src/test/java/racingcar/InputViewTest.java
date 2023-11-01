package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InputViewTest {

    private InputView inputView;
    private final String EXCEPTION_CAR_NAME = "1~5 길이의 영어로 된 이름을 ,로 구분하여 중복과 공백없이 입력 해 주세요.";
    private final String EXCEPTION_EXECUTION_TIME = "양의 정수를 입력 해 주세요";
    private final String EXCEPTION_INPUT_JUST_ONE = "2개 이상 자동차를 입력해 주세요.";

    @BeforeEach
    void setUp() {
        inputView = new InputView();
    }

    @Test
    void 자동차이름_콤마_유무_테스트() {
        String input = "pobijason";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThatThrownBy(() -> inputView.inputCarName())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EXCEPTION_INPUT_JUST_ONE);
    }

    @Test
    void 정규식에_맞는지_확인() {
        String input = "포비,제이슨";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThatThrownBy(() -> inputView.inputCarName())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EXCEPTION_CAR_NAME);
    }

    @Test
    void 입력값_길이_확인() {
        String input = "백엔드왕이될사나이,pobi";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThatThrownBy(() -> inputView.inputCarName())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EXCEPTION_CAR_NAME);
    }

    @Test
    void 중복된_자동차_테스트() {
        String input = "pobi,pobi,pobi,jason";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThatThrownBy(() -> inputView.inputCarName())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EXCEPTION_CAR_NAME);
    }

    @Test
    void 횟수_음수_입력_예외_테스트() {
        String input = "-5";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThatThrownBy(() -> inputView.inputExecutionTime())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EXCEPTION_EXECUTION_TIME);
    }

    @Test
    void 횟수_실수_입력_테스트() {
        String input = "3.141592";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThatThrownBy(() -> inputView.inputExecutionTime())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EXCEPTION_EXECUTION_TIME);
    }

    @Test
    void 횟수_숫자가_아닌값_입력_테스트() {
        String input = "executionTime";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThatThrownBy(() -> inputView.inputExecutionTime())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EXCEPTION_EXECUTION_TIME);

    }

}
