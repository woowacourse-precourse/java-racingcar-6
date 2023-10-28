package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import racingcar.AttemptsInput;
import racingcar.CarNameInput;

public class StudyTest {

    @Test
    public void 유저이름_입력시_오류(){
        CarNameInput carNameInput = new CarNameInput();
        String userNameInput = "apple,happycat,wind";
        assertThrows(IllegalArgumentException.class,
            ()->carNameInput.detectErrorInUserInput(userNameInput));
    }

    @Test
    public  void 시도횟수_변환시_오류(){
        AttemptsInput attemptsInput = new AttemptsInput();
        String number = "숫자";
        assertThrows(IllegalArgumentException.class,
            ()->attemptsInput.isNumber(number));
    }

    @Test
    public void 시도횟수_변환_확인(){
        AttemptsInput attemptsInput = new AttemptsInput();
        String number = "3";
        assertThat(attemptsInput.isNumber(number)).isEqualTo(3);
    }

    @Test
    public void testValidNumber() {
        AttemptsInput parser = new AttemptsInput();
        String userInput = "42";
        int result = parser.isNumber(userInput);
        assertEquals(42, result);
    }

    @Test
    public void testInvalidNumber() {
        AttemptsInput parser = new AttemptsInput();
        String userInput = "abc"; // Invalid input
        try {
            parser.isNumber(userInput);
            fail("예외 발생 안함");
        } catch (IllegalArgumentException e) {
            // Expected IllegalArgumentException
        }
    }
}
