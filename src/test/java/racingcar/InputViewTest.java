package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.variable.MagicVariable;
import racingcar.view.InputView;

class InputViewTest {
    InputView inputView = new InputView();
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
    @DisplayName("사용자 입력 인스턴스 생성")
    void InputView_인스턴스_생성확인() {
        InputView inputView = new InputView();
    }

    @Test
    @DisplayName("자동차 이름 입력 동작확인")
    public void getCarNameInput_동작확인() {
        provideInput("kim,da,bo,mi\n");
        String result = inputView.getCarNameInput();
        assertThat(result).isEqualTo("kim,da,bo,mi");
    }

    @Test
    @DisplayName("시도 횟수 입력 동작확인")
    public void getTryCount_동작확인() {
        provideInput("3\n");
        int result = inputView.getTryCount();
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("자동차 이름 중복에 대한 예외 확인")
    void checkCarNameExceptions_중복확인() {
        String[] inputArr = {"da","da","bo","mi"};
        assertThatThrownBy(() ->  inputView.testCarNameExceptions(inputArr))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MagicVariable.CAR_DUPLICATE_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("자동차 이름 대문자 입력에 대한 예외 확인")
    void checkCarNameExceptions_대문자불가확인() {
        String[] inputArr = {"Da","da","bo","mi"};
        assertThatThrownBy(() ->  inputView.testCarNameExceptions(inputArr))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MagicVariable.CAR_NAME_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("자동차 이름 숫자 입력에 대한 예외 확인")
    void checkCarNameExceptions_숫자불가확인() {
        String[] inputArr = {"11","da","bo","mi"};
        assertThatThrownBy(() ->  inputView.testCarNameExceptions(inputArr))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MagicVariable.CAR_NAME_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("자동차 이름 길이 초과에 대한 예외 확인")
    void checkCarNameExceptions_길이확인() {
        String[] inputArr = {"kimdabomi","da","bo","mi"};
        assertThatThrownBy(() ->  inputView.testCarNameExceptions(inputArr))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MagicVariable.CAR_NAME_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("자동차 이름 길이 미만에 대한 예외 확인")
    void checkCarNameExceptions_길이확인2() {
        String[] inputArr = {"","da","bo","mi"};
        assertThatThrownBy(() ->  inputView.testCarNameExceptions(inputArr))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MagicVariable.CAR_NAME_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("자동차 이름 공백 포함에 대한 예외 확인")
    void checkCarNameExceptions_공백포함불가확인() {
        String[] inputArr = {"kim"," da","bo","mi"};
        assertThatThrownBy(() ->  inputView.testCarNameExceptions(inputArr))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MagicVariable.CAR_NAME_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("시도 횟수 범위에 대한 예외 확인")
    void checkTryCountExceptions_범위확인() {
        int tryCount = 0;
        assertThatThrownBy(() ->  inputView.testTryCountExceptions(tryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MagicVariable.TRY_COUNT_RANGE_ERROR_MESSAGE);
    }
}