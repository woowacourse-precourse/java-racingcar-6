package racingcar;
import static camp.nextstep.edu.missionutils.test.Assertions.*;

import racingcar.valid.ValidCheck;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidTest {

    @Test
    void 자동차이름_비어있는_입력(){
        final ValidCheck validCheck = new ValidCheck();
        assertSimpleTest(()->assertThatThrownBy(()->validCheck.checkNameNoInput(""))
                .isInstanceOf(IllegalArgumentException.class));
    }
    @Test
    void 자동차이름_5자리초과_입력(){
        final ValidCheck validCheck = new ValidCheck();
        assertSimpleTest(()->assertThatThrownBy(()->validCheck.checkNameLength("aaaaaa"))
                .isInstanceOf(IllegalArgumentException.class));
    }
    @Test
    void 자동차개수_1대_입력(){
        final ValidCheck validCheck = new ValidCheck();
        String[] cars = new String[1];
        cars[0] = "a";
        assertSimpleTest(()->assertThatThrownBy(()->validCheck.checkRacingCars(cars))
                .isInstanceOf(IllegalArgumentException.class));
    }

}
