package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.ObjectArrayAssert;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 자동차_생성(){
        Application application = new Application();
        String[] split = {"pobi", "crong", "wooni"};

        Car[] carlist = application.createCar(split);

        assertThat(carlist[0].getName()).isEqualTo("pobi");
        assertThat(carlist[0].getPos()).isEqualTo(0);
        assertThat(carlist[1].getName()).isEqualTo("crong");
        assertThat(carlist[1].getPos()).isEqualTo(0);
        assertThat(carlist[2].getName()).isEqualTo("wooni");
        assertThat(carlist[2].getPos()).isEqualTo(0);

    }
    
    @Test
    void 전진_조건(){
        Application application = new Application();
        int randomNumberTest1 = 3;
        int randomNumberTest2 = 5;

        assertThat(application.go(randomNumberTest1)).isEqualTo(true);
        assertThat(application.go(randomNumberTest2)).isEqualTo(false);
    }

    @Test
    void 이름_분류(){
        Application application = new Application();
        String input = "pobi,crong,woni";
        String[] devidedName = application.devide_name(input);

        assertThat(devidedName).containsExactly("pobi", "crong", "woni");
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
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
