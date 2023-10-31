package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.validation.NameInputValidation;

public class InputViewTest {
    private final InputStream systemInBackUp = System.in; // 원래 System.in 백업
    private final NameInputValidation nameInputValidation = new NameInputValidation();
    private final InputView inputView = new InputView(nameInputValidation);

    @Test
    @DisplayName("자동차 이름 입력받기 테스트")
    public void askCarNamesTest() {
        // 원하는 입력값 InputStream 에 추가
        String input = "pobi,woni,jun";
        ByteArrayInputStream testIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(testIn);
        // test
        assertThat(inputView.askCarNames())
                .contains("pobi", "woni", "jun");
        // System.in 복원
        System.setIn(systemInBackUp);
    }
}
