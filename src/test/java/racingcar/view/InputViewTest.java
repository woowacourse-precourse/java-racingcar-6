package racingcar.view;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {
    private static InputView inputView;
    @BeforeAll
    static void initInputView() {
        inputView = new InputView();
    }

    @Test
    @DisplayName("입력한 이름 리스트 반환 테스트: 정상 반환")
    void testCarNameInputView() {
        String testString = "pobi,java,test";
        List<String> testList = List.of("pobi","java","test");

        System.setIn(new ByteArrayInputStream(testString.getBytes()));
        assertThat(inputView.inputCarName()).isEqualTo(testList);
    }

    @Test
    @DisplayName("입력한 시도 횟수 정수형 반환 테스트: 정상 반환")
    void testTryNumberInputView() {
        String testString = "10";
        int returnNumber = 10;

        System.setIn(new ByteArrayInputStream(testString.getBytes()));
        assertThat(inputView.inputTryNumber()).isEqualTo(returnNumber);
    }
}
