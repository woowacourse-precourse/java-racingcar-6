package racingcar.user;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ValidatorTest {
    Validator validator = new Validator();
    @Test
    void 이름_길이_체크() {
        String input = "aaa,bbb,ccccc,dddddd";
        assertThrows(IllegalArgumentException.class,()->{
            validator.carNameCheck(input);
        });


    }
    @Test
    void 이름_중복_체크(){
        String[] input = {"aaa","aaaa","aaa"};
        assertThrows(IllegalArgumentException.class,()->{
            validator.duplicatedNameCheck(input);
        });
    }
    @Test
    void 숫자_타입_체크() {
        String input = "123a";
        String regex = "^[1-9][0-9]*$";
        assertThrows(IllegalArgumentException.class,()->{
            validator.gameRoundCheck(input);
        });
    }
}