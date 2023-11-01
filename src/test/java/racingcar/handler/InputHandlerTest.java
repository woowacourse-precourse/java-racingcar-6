package racingcar.handler;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class InputHandlerTest {

    InputHandler inputHandler = new InputHandler();

    @Test
    @DisplayName("자동차 이름 문자열을 리스트로 변환")
    void convertNamesToListTest() {
        List<String> expectedList = Arrays.asList("kim", "lee", "park");

        String carNames = "kim,lee,park";
        List<String> actualList = inputHandler.toNameList(carNames);

        assertThat(actualList).isEqualTo(expectedList);
    }

    @Test
    @DisplayName("자동차 이름 공백시 예외 발생 테스트")
    void convertBlankNamesExceptionTest() {
        String blankName = "";
        assertThatThrownBy(() -> inputHandler.toNameList(blankName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름 중복시 예외 발생 테스트")
    void convertDuplicateNamesExceptionTest() {
        String duplicateName = "kim,kim,kim";
        assertThatThrownBy(() -> inputHandler.toNameList(duplicateName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름 길이 허용범위 초과시 예외 발생 테스트")
    void convertLongNamesExceptionTest() {
        String longName = "honggildong";
        assertThatThrownBy(() -> inputHandler.toNameList(longName))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    @DisplayName("시도횟수 입력값 타입 변환 테스트")
    void convertAttemptsToInt() {
        String inputAttempts = "5";
        int attempts = inputHandler.toInt(inputAttempts);

        assertThat(attempts).isEqualTo(Integer.parseInt(inputAttempts));
    }

    @Test
    @DisplayName("시도횟수 입력값 변환 예외 테스트")
    void convertAttemptsToIntExceptionTest() {
        String alphabetAttempts = "a";

        assertThatThrownBy(() -> inputHandler.toInt(alphabetAttempts))
                .isInstanceOf(IllegalArgumentException.class);
    }

}