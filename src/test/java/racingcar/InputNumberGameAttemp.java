package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.control.GameProcess;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

// TODO: 10/29/23 입력 검사 확인
public class InputNumberGameAttemp {
    private GameProcess gameProcess;

    public static InputStream setReadLine(String readLine) {
        String[] inputs = readLine.split("=");
        String result = String.join(System.lineSeparator(), inputs);
        return new ByteArrayInputStream(result.getBytes());
    }

    @BeforeEach
    void setup() {
        gameProcess = new GameProcess();
    }

    @DisplayName("몇번의 게임 진행을 할 것인지 입력한다.")
    @ParameterizedTest
    @ValueSource(strings = {"=132 123=문자열=0문자열=!@#$%=0=-3", "", "", "", "", "", ""})
    public void inputNameOfRaceCarTest_Exception_01(String inputStr) throws Exception {

        // when
        InputStream readLine = setReadLine(inputStr);
        System.setIn(readLine);

        // then
        assertThatThrownBy(() -> {
            gameProcess.inputNumberGameAttempts();
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
