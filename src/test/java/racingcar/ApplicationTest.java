package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import java.util.List;

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
    void 시도_횟수에_대한_예외_처리(){
        assertThatThrownBy(() -> runException("pobi,woni", "a"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> runException("pobi,subi,woni", "-4"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 메시지_출력(){
        assertSimpleTest(
                () -> {
                   run("pobi,woni", "1");
                   assertThat(output()).contains("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)",
                           "시도할 회수는 몇회인가요?",
                           "실행 결과");
                }
                );
    }

    @Test
    void 공동_우승자_출력(){
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 난수_생성(){
        List<Integer> numbers = new ArrayList<Integer>();
        for(int i = 0; i <= 9; i++)
            numbers.add(i);
        while(!numbers.isEmpty()){
            Integer randomNumber = Randoms.pickNumberInRange(0,9);
            if(numbers.contains(randomNumber))
                numbers.remove(randomNumber);
        }

        assertThat(numbers.size())
                .isEqualTo(0);
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
