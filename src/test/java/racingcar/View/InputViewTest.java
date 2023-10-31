package racingcar.View;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputViewTest {

    private InputView inputView;
    InputStream originalSystemIn;

    @BeforeEach
    void setUp() {
        inputView = new InputView();
        originalSystemIn = System.in;
    }

    @AfterEach
    void tearDown() {
        System.setIn(originalSystemIn);
        Console.close();
    }

    @Test
    @DisplayName("유효한 자동차 이름을 입력하면 반환 값이 입력한 값과 동일해야 함")
    void givenValidCarNames_whenInputCar_thenReturnsSameNames() {
        String input = "car1,car2,car3";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        String result = inputView.inputCar();

        assertThat(result).isEqualTo(input + ",");
    }

    @Test
    @DisplayName("유효하지 않은 자동차 이름을 입력하면 반환 값이 null 이어야 함")
    void givenInvalidCarNames_whenInputCar_thenReturnsNull() {
        String input = ",, car3";
        System.setIn(new ByteArrayInputStream(input.trim().getBytes()));

        String result = inputView.inputCar();

        assertThat(result).isNull();
    }

    @Test
    @DisplayName("유효한 레이스 시간을 입력하면 반환 값이 입력한 값과 동일해야 함")
    void givenValidRaceTime_whenInputRaceTime_thenReturnsSameTime() {
        String input = "5";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        int result = inputView.inputRaceTime();

        assertThat(result).isEqualTo(5);
    }

    @Test
    @DisplayName("유효하지 않은 레이스 시간을 입력하면 반환 값이 -1이어야 함")
    void givenInvalidRaceTime_whenInputRaceTime_thenReturnsMinusOne() {
        String input = "invalid_time";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        int result = inputView.inputRaceTime();

        assertThat(result).isEqualTo(-1);
    }

    @Test
    @DisplayName("null 입력 시, NullPointerException 발생해야 함")
    void givenNullInput_whenInputCar_thenThrowsNullPointerException() {
        System.setIn(null);

        assertThatCode(() -> inputView.inputCar())
                .isInstanceOf(NullPointerException.class);
    }



}