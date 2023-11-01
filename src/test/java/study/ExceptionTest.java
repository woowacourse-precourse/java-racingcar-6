package study;

import org.junit.jupiter.api.Test;
import racingcar.validation.InputException;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class ExceptionTest {
    private InputException inputException = new InputException();
    @Test
    void 이름_미입력_처리(){
        String input ="";
        assertThatThrownBy(()->InputException.carNameValidation(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름_공백시_처리(){
        String input ="pobi,";
        assertThatThrownBy(()->InputException.carNameValidation(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름_중복시_처리(){
        String input ="pobi,pobi";
        assertThatThrownBy(()->InputException.carNameValidation(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름_길이_초과시_처리(){
        String input = "pobi,dfqdfe,love";
        assertThatThrownBy(()->InputException.carNameValidation(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 시도횟수_1이하_숫자_입력시_처리(){
        String input = "-3";
        assertThatThrownBy(() -> InputException.numberValidation(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도횟수_문자입력시_처리(){
        String input ="dfe";
        assertThatThrownBy(() -> InputException.numberValidation(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
