package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.exception.ExceptionHandler;

public class ExceptionTest extends NsTest {
    @Test
    public void 이름_길이_짧음(){
        //given
        String test1 = "lucy";
        String test2 = "   ";
        String test3 = "";

        //when & then
        Assertions.assertDoesNotThrow(() -> ExceptionHandler.shortNameLengthException(test1));
        Assertions.assertDoesNotThrow(() -> ExceptionHandler.shortNameLengthException(test2));
        Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionHandler.shortNameLengthException(test3));
    }
    @Test
    public void 이름_길이_김(){
        //given
        String test1 = "lucy";
        String test2 = "   ";
        String test3 = "luccccy";

        //when & then
        Assertions.assertDoesNotThrow(() -> ExceptionHandler.LongNameLengthException(test1));
        Assertions.assertDoesNotThrow(() -> ExceptionHandler.LongNameLengthException(test2));
        Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionHandler.LongNameLengthException(test3));
    }
    @Test
    public void 공백_입력(){
        //given
        String test1 = "tom,lucy";
        String test2 = "";

        //when & then
        Assertions.assertDoesNotThrow(() -> ExceptionHandler.blankNamesException(test1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionHandler.blankNamesException(test2));
    }
    @Test
    public void 이름_중복(){
        //given
        String test1 = "tom,lucy";
        String test2 = "tom,lucy,tom,hemy";

        //when & then
        Assertions.assertDoesNotThrow(() -> ExceptionHandler.duplicateNameException(test1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionHandler.duplicateNameException(test2));
    }
    @Test
    public void 최대_값_이상_숫자_입력(){
        //given
        String test1 = "5";
        String test2 = "30";
        String test3 = "1000000000000000";

        //when & then
        Assertions.assertDoesNotThrow(() -> ExceptionHandler.tooBigDigitException(test1));
        Assertions.assertDoesNotThrow(() -> ExceptionHandler.tooBigDigitException(test2));
        Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionHandler.tooBigDigitException(test3));
  }
    @Test
    public void 음수_또는_0_입력(){
        //given
        String test1 = "5";
        String test2 = "0";
        String test3 = "-100";

        //when & then
        Assertions.assertDoesNotThrow(() -> ExceptionHandler.zeroOrMinusTryNumberException(test1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionHandler.zeroOrMinusTryNumberException(test2));
        Assertions.assertThrows(IllegalArgumentException.class, () -> ExceptionHandler.zeroOrMinusTryNumberException(test3));
    }



    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
