package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import domain.Cars;
import domain.InputUser;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    @Test
    void split_메서드로_주어진_값을_구분() {
        InputUser inputUser = new InputUser();
        String userInput = "pobi,jun" ;
        List<String> input = inputUser.getNames(userInput);

        assertThat(input).contains("jun", "pobi");
        assertThat(input).containsExactly("pobi", "jun");
    }
    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 랜덤숫자가_4이상일_경우(){
        Cars cars = new Cars();
        boolean overFour = cars.randomNum();
        if (cars.num<4){
            assertFalse(overFour);
        } else if (cars.num>=4) {
            assertTrue(overFour);
        }
    }

    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 숫자입력을_받을_때_숫자가_아닌_것에_대한_예외_처리() {
        InputUser inputUser = new InputUser();
        String testString = "asb";

        assertThatThrownBy(() -> inputUser.getNumber(Integer.parseInt(testString)))
                        .isInstanceOf(IllegalArgumentException.class);

    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
