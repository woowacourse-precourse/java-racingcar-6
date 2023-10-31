package racingcar.view;

import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class InputViewTest {
    private static InputView inputView;
    @BeforeAll
    static void initInputView() {
        inputView = new InputView();
        String testString = "pobi,java,test\n10\n";
        System.setIn(new ByteArrayInputStream(testString.getBytes()));
    }

    @Test
    @Order(1)
    @DisplayName("입력한 이름 리스트 반환 테스트: 정상 반환")
    void testCarNameInputView() {
        List<String> testList = List.of("pobi","java","test");
        assertThat(inputView.inputCarName()).isEqualTo(testList);
    }

    @Test
    @Order(2)
    @DisplayName("입력한 시도 횟수 정수형 반환 테스트: 정상 반환")
    void testTryNumberInputView() {
        String testString = "10\n";
        int returnNumber = 10;

//        System.setIn(new ByteArrayInputStream(testString.getBytes()));
        assertThat(inputView.inputTryNumber()).isEqualTo(returnNumber);
    }
}
