package racingcar.view;

import static org.assertj.core.api.Assertions.*;
import static racingcar.view.InputView.*;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {
    InputView inputView;

    InputStream inputStream;

    @BeforeEach
    void reset() {
        inputView = createInputView();
    }

    void resetStream(String input) {
        inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
    }

    @AfterEach
    void tearDown() {
        Console.close();
        //System.setIn(System.in);
    }

    @Test
    @DisplayName("레이서 이름 입력 테스트")
    void testInputCars() {
        //given
        List<String> inputList;
        String inputString = "pobi,blur";

        //when
        resetStream(inputString);
        inputList = inputView.inputCars();

        //then
        assertThat(inputList).isEqualTo(Arrays.asList("pobi", "blur"));
    }

    @Test
    @DisplayName("레이서 이름 입력 예외 테스트")
    void testInputCarsException() {
        //given
        String inputString = "po bi,blur";

        //when
        resetStream(inputString);

        //then
        assertThatThrownBy(() -> inputView.inputCars()).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("레이싱 횟수 입력 테스트")
    void testInputCounter() {
        //given
        Integer inputList;
        String inputString = "1";

        //when
        resetStream(inputString);
        inputList = inputView.inputCountNumber();

        //then
        assertThat(inputList).isEqualTo(1);
    }

    @Test
    @DisplayName("레이싱 횟수 입력 예외 테스트")
    void testInputCounterException() {
        //given
        String inputString = "a";

        //when
        resetStream(inputString);

        //then
        assertThatThrownBy(() -> inputView.inputCountNumber()).isInstanceOf(IllegalArgumentException.class);
    }
}