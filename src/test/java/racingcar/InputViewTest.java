package racingcar;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.view.InputView;


public class InputViewTest {
    InputView inputView = new InputView();

    @Test
    public void testValidateCarsInput() {
        // 검증: 이름의 길이가 범위 밖인 경우
        List<String> invalidLengthList = Arrays.asList("a","adawdawdawdaw");
        assertThrows(IllegalArgumentException.class, ()-> inputView.validateCarsInput(invalidLengthList));

        // 검증: 이름이 영문자가 아닌 경우
        List<String> notEnglishNameList = Arrays.asList("자동차","소나타");
        assertThrows(IllegalArgumentException.class, ()-> inputView.validateCarsInput(notEnglishNameList));

        // 검증: 이름에 공백이 있는 경우
        List<String> withSpaceList = Arrays.asList("car 1", "car2", "car3");
        assertThrows(IllegalArgumentException.class, ()-> inputView.validateCarsInput(withSpaceList));

        // 검증: 중복된 이름이 있는 경우
        List<String> withDuplicationList = Arrays.asList("car1","car1","car3");
        assertThrows(IllegalArgumentException.class, ()-> inputView.validateCarsInput(withDuplicationList));
    }

    @Test
    public void testValidateRoundsInput() {
        // 검증: 횟수가 범위 내인 경우
        int validInput = 5;
        assertDoesNotThrow(() -> inputView.validateRoundsInput(validInput));

        // 검증: 횟수가 최소값보다 작은 경우
        int smallInput = 0;
        assertThrows(IllegalArgumentException.class, () -> inputView.validateRoundsInput(smallInput));

        // 검증: 횟수가 최대값보다 큰 경우
        int bigInput = 1000;
        assertThrows(IllegalArgumentException.class, () -> inputView.validateRoundsInput(bigInput));
    }
}
