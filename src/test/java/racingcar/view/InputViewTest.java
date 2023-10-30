package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    @Test
    void 자동차_이름_입력_테스트() {
        // Given
        String input = "pobi,woni,jun";

        // 문자열을 ByteArrayInputStream으로 변환
        InputStream in = new ByteArrayInputStream(input.getBytes());
        // 표준 입력을 재지정
        System.setIn(in);

        // When
        InputView inputView = new InputView();
        String carNames = inputView.readCarName();

        // Then
        assertEquals(input, carNames);
    }
}