package racingcar;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InputTest {
    @Test
    public void 이름입력의_길이가_5보다_클_때_예외(){
        // given
        String input = "veryverylong";

        // when
        // then
        Assertions.assertThrows(IllegalArgumentException.class, ()-> Application.validateName(input));
    }

    @Test
    public void 이름입력에_스페이스바가_들어있을_때_예외(){
        // given
        String input = " ss ";
        List<String> testList = Arrays.asList(" ", "s ", "   ", " a b");

        // when
        // then
        Assertions.assertThrows(IllegalArgumentException.class, ()-> Application.validateName(input));

        for (String test: testList){
            Assertions.assertThrows(IllegalArgumentException.class, ()-> Application.validateName(test));
        }
    }

    @Test
    public void 이름입력이_비어있을_때_예외(){
        // given
        String input = "";

        // when
        // then
        Assertions.assertThrows(IllegalArgumentException.class, ()-> Application.validateName(input));
    }
}
