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

    @Test
    void 입력받은_자동차_이름_문자열의_맨앞이_컴마_일때_IllegalArgumentException() {
        String carsName = ",jun,sang";

        assertThatThrownBy(() -> inputException.carsNameException(carsName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력받은_자동차_이름_문자열의_맨뒤가_컴마_일때_IllegalArgumentException() {
        String carsName = "junn,sang,";

        assertThatThrownBy(() -> inputException.carsNameException(carsName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력받은_자동차_이름_문자열의_중간에_연속된_컴마가_나올때_IllegalArgumentException() {
        String carsName = "junn,,sang";

        assertThatThrownBy(() -> inputException.carsNameException(carsName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름의_길이가_5초과_일때_IllegalArgumentException() {
        String carsName = "junnn,sanggg";

        assertThatThrownBy(() -> inputException.carsNameException(carsName))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
