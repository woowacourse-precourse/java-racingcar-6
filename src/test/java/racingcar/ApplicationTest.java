package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

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

    @Test
    void Car_setName_이름_6이상일_경우_예외_처리(){
        String name = "abcdfe";

        assertThatThrownBy(() -> new Car(name))
                    .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void Car_setName_이름_null일_경우_예외_처리(){
        String name = null;

        assertThatThrownBy(() -> new Car(name))
                    .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void addComma_문자열_empty인_경우(){
        String str = "";
        String result = Application.addComma(str);
        assertThat(result).isEqualTo(str);
    }

    @Test
    void addComma_문자열_empty가_아닌_경우(){
        String str = "abc";
        String result = Application.addComma(str);
        assertThat(result).isEqualTo("abc, ");
    }

    
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
