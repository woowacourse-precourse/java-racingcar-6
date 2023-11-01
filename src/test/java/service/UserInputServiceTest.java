package service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UserInputServiceTest {
    UserInputService userInputService = new UserInputService();

    public static InputStream setReadLine(String readLine) {
        return new ByteArrayInputStream(readLine.getBytes());
    }


    @Test
    public void 자동차_이름_입력() {
        // given
        String carName = "바다";
        InputStream readLine = setReadLine(carName);
        System.setIn(readLine);

        // when
        List<String> carNames = userInputService.carName();

        // then
        assertThat(carNames).contains(carName);
    }
}
