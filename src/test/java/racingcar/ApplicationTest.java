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
    void 차이름_순서(){
        assertSimpleTest(()->{
            Car car1 =new Car("test");
            Car car2 =new Car("test2");
            Car car3 =new Car("test3");
            assertThat(car1.getName()).isEqualTo("test");
            assertThat(car2.getName()).isEqualTo("test2");
            assertThat(car3.getName()).isEqualTo("test3");
        });
    }

    @Test
    void 옳은_출력값_형식(){
        assertSimpleTest(()->{
            run("pobi,woni,sangh","1");
            assertThat(output()).contains("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)","시도할 회수는 몇회인가요?","pobi :","최종 우승자 :");
        });
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
