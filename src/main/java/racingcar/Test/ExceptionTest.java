package racingcar.Test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.View.InputView;
import static org.junit.jupiter.api.Assertions.assertThrows;



public class ExceptionTest {
    @Test
    @DisplayName("유저의 첫번째 입력으로 빈문자열을 입력했을경우")
    void testEmptyStringInputByUser(){
        assertThrows(IllegalArgumentException.class, () -> InputView.createCarsList(" "));
    }

    @Test
    @DisplayName("유저의 첫번째 입력 값이 `,` 를 기준으로 5자를 초과할 경우")
    void testInputExceedingMaxLength(){
        assertThrows(IllegalArgumentException.class, () -> InputView.createCarsList("supercar"));
    }
    @Test
    @DisplayName("자동차의 이름을 중복으로 생성했을때")
    void testDuplicateCarNames(){
        assertThrows(IllegalArgumentException.class, () -> InputView.createCarsList("car1,car1"));
    }

    @Test
    @DisplayName(" `,`뒤로 아무것 도 입력 하지 않는 경우")
    void testEmptyInputAfterComma(){
        assertThrows(IllegalArgumentException.class, () -> InputView.createCarsList("car1,"));
    }
    @Test
    @DisplayName("유저의 두번째 입력 값이 문자열인 경우")
    void testSecondInputWhenStringGiven(){
        assertThrows(IllegalArgumentException.class, () -> InputView.parseNumber("ddd"));
    }
    @Test
    @DisplayName("유저의 두번째 입력이 정수가 아닌 숫자인 경우")
    void testNonIntegerInputByUser(){
        assertThrows(IllegalArgumentException.class, () -> InputView.parseNumber("4.3"));
    }
    @Test
    @DisplayName("유저의 두번재 입력을 아무것도 안했을경우 ")
    void testEmptyInputForTrialCountn(){
        assertThrows(IllegalArgumentException.class, () -> InputView.parseNumber(" "));
    }
    @Test
    @DisplayName("유저의 두번재 입력이  0을 입력한 경우")
    void testZeroAttemptsInput(){
        assertThrows(IllegalArgumentException.class, () -> InputView.parseNumber("0"));
    }

}
