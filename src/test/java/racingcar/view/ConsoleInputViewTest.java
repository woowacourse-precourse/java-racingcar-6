package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ConsoleInputViewTest {
    @Test
    void getUserInput() {
        // 가짜 입력 스트림 생성
        ByteArrayInputStream fakeInput = new ByteArrayInputStream("Test Input".getBytes());

        // System.in을 가짜 입력 스트림으로 재설정
        System.setIn(fakeInput);

        // getUserInput 메서드 호출
        String userInput = ConsoleInputView.getUserInput();

        // 원래 System.in 복원
        System.setIn(System.in);

        // 사용자 입력과 예상 결과를 비교
        assertEquals("Test Input", userInput);
    }
}
