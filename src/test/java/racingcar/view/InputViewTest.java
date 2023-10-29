package racingcar.view;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class InputViewTest {
    private InputView inputView;

    @AfterEach
    void restoreSystemIn() {
        Console.close();
    }

    @Test
    void inputCarNames() {
        //given
        inputView = new InputView();
        String input = "Tom,Bob,Lisa";

        // 임시로 System.in을 변경하여 원하는 입력값을 제공
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        //when
        String[] result = inputView.inputCarNames();

        // 테스트 후에는 System.in을 원래대로 복원
        System.setIn(System.in);

        //then
        assertThat(result).containsExactly("Tom", "Bob", "Lisa");

    }

    @Test
    void inputTryNumber() {
        //given
        inputView = new InputView();
        String input = "5";

        // 임시로 System.in을 변경하여 원하는 입력값을 제공
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        //when
        String result = inputView.inputTryNumber();

        // 테스트 후에는 System.in을 원래대로 복원
        System.setIn(System.in);

        //then
        assertThat(result).isEqualTo("5");
    }
}