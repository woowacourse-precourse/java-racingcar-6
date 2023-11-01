package racingcar.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ExceptionTest {

    Checker checker = new Checker();
    Parser parser = new Parser();

    @Test
    public void minValueExceptionTest(){
        String input=",pobi";
        List<String> list = parser.stringCarNameToArrayList(input);

        Assertions.assertThatThrownBy(() -> checker.inputCarName(input, list))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("최소");
    }

    @Test
    public void maxValueExceptionTest(){
        String input="1,pobi1234";
        List<String> list = parser.stringCarNameToArrayList(input);

        Assertions.assertThatThrownBy(() -> checker.inputCarName(input, list))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("최대");
    }

    @Test
    public void spaceValueExceptionTest(){
        String input="1,pob i";
        List<String> list = parser.stringCarNameToArrayList(input);

        Assertions.assertThatThrownBy(() -> checker.inputCarName(input, list))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공백");
    }

    @Test
    public void duplicatedValueExceptionTest(){
        String input="a,b,a";
        List<String> list = parser.stringCarNameToArrayList(input);

        Assertions.assertThatThrownBy(() -> checker.inputCarName(input, list))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복");
    }

    @Test
    public void finalValueExceptionTest(){
        String input="d,f,";
        List<String> list = parser.stringCarNameToArrayList(input);

        Assertions.assertThatThrownBy(() -> checker.inputCarName(input, list))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("마지막");
    }

    @Test
    public void intValueExceptionTest(){
        String input="d";

        Assertions.assertThatThrownBy(() -> checker.inputAttemptFinal(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자");
    }
}
