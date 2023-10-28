package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.control.GameProcess;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputStringOfRaceCarTest {

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

    @DisplayName("경주할 자동차 이름을 입력하는 예외 유발 메서드 테스트 - 5이상 차동차이름")
    @ParameterizedTest
    @ValueSource(strings = {"falseNameFiveMore,woo,jun=한글,woo,jun=woo,=woo,,jun=woo=num3,jun=blank, ,jun=!@#$%,woo,jun=woo!,jun", "", "", "", "", "", "", "", ""})
    public void inputNameOfRaceCarTest_Exception_01(String inputStr) throws Exception {

        // when
        InputStream readLine = setReadLine(inputStr);
        System.setIn(readLine);

        // then
        assertThatThrownBy(() -> {
            gameProcess.inputNameOfRaceCar();
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
