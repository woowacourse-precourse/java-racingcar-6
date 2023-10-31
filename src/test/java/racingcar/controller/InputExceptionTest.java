package racingcar.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputExceptionTest {

    private InputException inputException;
    public InputExceptionTest(){
        inputException = new InputException();
    }

    @Test
    void 입력받은_자동차_이름_문자열이_빈_값일때_IllegalArgumentException() {
        String carsName = "";

        assertThatThrownBy(() -> inputException.carsNameException(carsName))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
