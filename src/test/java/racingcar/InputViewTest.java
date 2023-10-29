package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import camp.nextstep.edu.missionutils.Console;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputViewTest {
    private final InputStream originalSystemIn = System.in;

    private void provideInput(String inputData) {
        System.setIn(new ByteArrayInputStream(inputData.getBytes()));
    }

    @BeforeEach
    public void init() {
        System.setIn(originalSystemIn);
    }

    @AfterEach
    public void afterInit() {
        Console.close();
    }

    @Test
    void InputView_인스턴스_생성확인() {
        InputView inputView = new InputView();
    }

    @Test
    public void getCarNameInput_동작확인() {
        provideInput("kim,da,bo,mi\n");
        InputView inputView = new InputView();
        String result = inputView.getCarNameInput();
        assertThat(result).isEqualTo("kim,da,bo,mi");
    }

    @Test
    public void getTryCount_동작확인() {
        provideInput("3\n");
        InputView inputView = new InputView();
        int result = inputView.getTryCount();
        assertThat(result).isEqualTo(3);
    }
}