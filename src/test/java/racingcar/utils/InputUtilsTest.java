package racingcar.utils;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import racingcar.domain.Car;

public class InputUtilsTest extends NsTest {

    @Test
    void 유효한_자동차_이름_입력() {
        System.out.println("InputUtilsTest.유효한_자동차_이름_입력");
        String input = "Car1,Car2,Car3";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertSimpleTest(() -> {
            assertThat(InputUtils.promptForCar())
                    .usingRecursiveFieldByFieldElementComparatorOnFields("name")
                    .containsExactly(
                            new Car("Car1", 0),
                            new Car("Car2", 0),
                            new Car("Car3", 0)
                    );
        });
    }

    @Test
    void 빈_자동차_이름_입력_예외_처리() {
        System.out.println("InputUtilsTest.빈_자동차_이름_입력_예외_처리");
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isExactlyInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 길이가_5가_넘는_자동차_이름_입력_예외_처리() {
        System.out.println("InputUtilsTest.길이가_5가_넘는_자동차_이름_입력_예외_처리");
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji,abcd123", "1"))
                        .isExactlyInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도_횟수_음수_입력_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도_횟수_0_입력_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자가_아닌_시도_횟수_입력_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "abc"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
