package racingcar;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

public class UserInputHandlerTest extends InputTest {

    @Test
    @DisplayName("입력값이 List에 제대로 저장되는지 테스트")
    void testSetInput() {
        // 콘솔 입력창을 car1,car2,car3이라고 가정
        String input = "car1,car2,car3";
        String[] carNames = input.split(",");
        List<String> inputTest = new ArrayList<>(Arrays.asList(carNames));

        systemIn(input); // 입력 값을 "car1,car2,car3"로 임의로 지정
        String userInput = Console.readLine();
        carNames = userInput.split(",");

        List<String> cars = new ArrayList<>(Arrays.asList(carNames));
        // 실제 저장 값이 일치 하는지 확인
        assertThat(cars).isEqualTo(inputTest);
    }

    @Test
    @DisplayName("자동차 이름 5글자초과 예외 발생 테스트")
    void testValidateCarNames() {
        UserInputHandler userInputHandler = new UserInputHandler();
        String[] carNames = {"short", "normal", "longname"};

        // 예외를 발생시키는 코드 블록을 실행하고 예외에 대한 검증 : assertThatThrownBy()
        assertThatThrownBy(() -> userInputHandler.validateCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    @DisplayName("중복된 자동차 이름인 경우 테스트")
    void testDuplicateCarNames() {
        UserInputHandler userInputHandler = new UserInputHandler();
        String[] carNames = {"car1", "1212", "1212", "car20", "car20"};

        assertThatThrownBy(() -> userInputHandler.duplicateCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름이 공백인 경우 테스트")
    void testValidateInputNotEmpty() {
        UserInputHandler userInputHandler = new UserInputHandler();
        String carNames = "";

        assertThatThrownBy(() -> userInputHandler.validateInputNotEmpty(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력이 정상적으로 들어온 경우")
    void testNormalInput() {
        UserInputHandler userInputHandler = new UserInputHandler();
        String[] carNames = {"NAME1", "NAME2", "NAME5"};

        // 유효한 입력이 주어진 경우 예외가 발생하지 않아야 함
        assertThatCode(() -> userInputHandler.validateCarNames(carNames))
                .doesNotThrowAnyException();
    }


}