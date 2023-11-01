package racingcar;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.Service.InputException;

public class InputExceptionTest {
    @Test
    void charAt_이름_5글자_이상_일_때_예외_발생(){
        List<String> input = Arrays.asList("aaaaaa","bbbbb");
        InputException ex = new InputException();

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
                ex.validCarNameRange(input);
        });
    }


}
