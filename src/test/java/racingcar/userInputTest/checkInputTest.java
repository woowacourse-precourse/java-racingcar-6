package racingcar.userInputTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.utils.checkException;


public class checkInputTest {

    @DisplayName("쉼표가 없는 경우")
    @Test
    void withoutCommas() {
        final checkException checkException = new checkException();
        final String input = "ABC";

        checkException.checkCommaCarName(input);
    }

    @DisplayName("자동차 이름이 다섯 글자를 넘는 경우")
    @Test
    void overFiveWords() {
        final checkException checkException = new checkException();
        final String[] carNameArray = {"pobi", "woni", "junnnnnnnn"};

        checkException.checkCarNameException(carNameArray);
    }

    @DisplayName("시도 횟수 입력이 정수가 아닌 경우")
    @Test
    void countNotInteger() {
        final checkException checkException = new checkException();
        final String askCount = "A";

        checkException.checkAskCount(askCount);
    }
}
