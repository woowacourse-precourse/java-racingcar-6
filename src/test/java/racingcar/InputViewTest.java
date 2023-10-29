package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;


import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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

    @Test
    void checkCarNameExceptions_중복확인() {
        String[] inputArr = {"da","da","bo","mi"};
        InputView inputView = new InputView();
        MagicVariable magicVariable = new MagicVariable();
        assertThatThrownBy(() ->  inputView.checkCarNameExceptions(inputArr))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(magicVariable.CAR_DUPLICATE_ERROR_MESSAGE);
    }

    @Test
    void checkCarNameExceptions_대문자불가확인() {
        String[] inputArr = {"Da","da","bo","mi"};
        InputView inputView = new InputView();
        MagicVariable magicVariable = new MagicVariable();
        assertThatThrownBy(() ->  inputView.checkCarNameExceptions(inputArr))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(magicVariable.CAR_NAME_ERROR_MESSAGE);
    }

    @Test
    void checkCarNameExceptions_숫자불가확인() {
        String[] inputArr = {"11","da","bo","mi"};
        InputView inputView = new InputView();
        MagicVariable magicVariable = new MagicVariable();
        assertThatThrownBy(() ->  inputView.checkCarNameExceptions(inputArr))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(magicVariable.CAR_NAME_ERROR_MESSAGE);
    }

    @Test
    void checkCarNameExceptions_길이확인() {
        String[] inputArr = {"kimdabomi","da","bo","mi"};
        InputView inputView = new InputView();
        MagicVariable magicVariable = new MagicVariable();
        assertThatThrownBy(() ->  inputView.checkCarNameExceptions(inputArr))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(magicVariable.CAR_NAME_ERROR_MESSAGE);
    }

    @Test
    void checkTryCountExceptions_범위확인() {
        int tryCount = 0;
        InputView inputView = new InputView();
        MagicVariable magicVariable = new MagicVariable();
        assertThatThrownBy(() ->  inputView.checkTryCountExceptions(tryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(magicVariable.TRY_COUNT_RANGE_ERROR_MESSAGE);
    }
}