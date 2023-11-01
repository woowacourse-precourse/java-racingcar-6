package racingcar.userInputTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.utils.checkException;


public class checkInputTest {

    @DisplayName("쉼표가 없는 경우")
    @Test
    void withoutCommas(){
        final checkException checkException = new checkException();
        final String input = "ABC";

        checkException.checkCommaCarName(input);
    }

}
