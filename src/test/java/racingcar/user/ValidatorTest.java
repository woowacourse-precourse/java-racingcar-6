package racingcar.user;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ValidatorTest {
    Validator validator = new Validator();
    @Test
    void 이름_길이_체크() {
        String input = "123456";
        assertThrows(IllegalArgumentException.class,()->{
            validator.carNameCheck(input);
        });
    }
    @Test
    void 이름_중복_체크(){
        String input = "aaa,aaaa,aaa";
        List<String> test = List.of(input.split(","));
        assertThrows(IllegalArgumentException.class,()->{
            validator.duplicatedNameCheck(test);
        });
    }
    @Test
    void 이름사이_공백_체크() {
        String input = "dd dd";
        assertThrows(IllegalArgumentException.class,()->{
            validator.carNameCheck(input);
        });
    }
    @Test
    void 특수문자체크() {
        String input = "d?ddd";
        assertThrows(IllegalArgumentException.class,()->{
            validator.carNameCheck(input);
        });
    }
    @Test
    void 숫자_타입_체크() {
        String input = "123?";
        String regex = "^[1-9][0-9]*$";
        assertThrows(IllegalArgumentException.class,()->{
            validator.gameRoundCheck(input);
        });
    }
    @Test
    void carNameCheck() {
        String input = "ccccc";
        assertDoesNotThrow(() -> validator.carNameCheck(input));
    }
    @Test
    void carNameCheck2() {
        String input = "123as";
        assertDoesNotThrow(() -> validator.carNameCheck(input));
    }
}