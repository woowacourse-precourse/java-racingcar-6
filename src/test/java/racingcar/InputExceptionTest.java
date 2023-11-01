package racingcar;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.Service.InputException;

public class InputExceptionTest {
    private InputException ex;
    @BeforeEach
    void setUp(){
        ex = new InputException();
    }
    @Test
    void charAt_이름_5글자_이상_일_때_예외_발생(){
        List<String> input = Arrays.asList("aaaaaa","bbbbb");

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
                ex.validCarNameRange(input);
        });
    }

    @Test
    void charAt_이름_중복이_있을_때_예외_발생(){
        List<String> input = Arrays.asList("aaa","bbb","aaa");

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            ex.validCarNameDuplicated(input);
        });
    }

}
