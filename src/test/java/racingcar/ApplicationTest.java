package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import controller.RoundDriver;
import data.DTO;

import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Map;

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
    void 이름이_null인_경우_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",,", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    
    @Test
    void 횟수가_문자열인_경우의_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("min,sin,lim", "a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    
    @Test
    void 횟수가_null인_경우의_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("min,sin,lim", null))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    
    @Test
    void init_records가_0만을_포함() {
    	String [] arr= {"lim","min","joo"};
        Map<String, Integer> result=new racingcar.Game().init_records(arr);

        assertThat(result).containsValues(0);
    }
    
    @Test
    void 기록_저장용_Map의_요소_확인() {
    	String [] arr= {"lim","min","joo"};
        Map<String, Integer> result=new racingcar.Game().init_records(arr);

        assertThat(result).containsOnlyKeys("lim","min","joo");
    }
    
    @Test
    void 점수만큼_하이픈_출력() {
    	
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
