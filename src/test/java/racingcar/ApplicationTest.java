package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    InputManager inputManager = new InputManager();
    Executor executor = new Executor();

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
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    
    @Test @DisplayName("띄어쓰기로_입력한_경우")
    void testCarName1() {

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("this That what", "3"))
                        .isInstanceOf(IllegalArgumentException.class)

        );
    }
    
    @Test @DisplayName("이름이_같은_경우")
    void testCarName2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("자동차,자동차,자동차", "5"))
                        .isInstanceOf(IllegalArgumentException.class)
                );
    }
    
    @Test @DisplayName("이름을_구분자로_구분하나_makeCars()")
    void testMakeCar1() {
        
        String input = "이름1,이름2";
        List<Car> cars = inputManager.makeCars(input);
        List<String> output = new ArrayList<>();
        
        cars.forEach(
                car -> output.add(car.getName())
        );
        assertThat(output).contains("이름2", "이름1");
        assertThat(output).containsExactly("이름1", "이름2");
        
    }

    @Test @DisplayName("구분자_없이_입력된_경우_그대로_반환하나_makeCars()")
    void testMakeCars2() {

        String input = "이름";
        List<Car> cars = inputManager.makeCars(input);
        List<String> output = new ArrayList<>();

        cars.forEach(
                car -> output.add(car.getName())
        );
        
        assertThat(output).contains("이름");

    }
    
    

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
