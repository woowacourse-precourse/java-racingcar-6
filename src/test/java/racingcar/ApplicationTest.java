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
    void 이름이_영어가_아닌_경우_예외_처리() {
    	assertSimpleTest(() ->
        assertThatThrownBy(() -> runException("pobi,한국", "1"))
                .isInstanceOf(IllegalArgumentException.class)
    	);
    }
    
    @Test
    void 이동_횟수가_숫자가_아닌_경우_예외_처리() {
    	assertSimpleTest(() ->
        assertThatThrownBy(() -> runException("pobi,jun", "a"))
                .isInstanceOf(IllegalArgumentException.class)
    	);
    }
    
    @Test
    void 이름이_한개만_적힌_경우_예외_처리() {
    	assertSimpleTest(() -> 
    	assertThatThrownBy(() -> runException("pobi","1"))
    		.isInstanceOf(IllegalArgumentException.class)
    	);
    }
    
    @Test
    void 이동_횟수가_0으로_시작했을_경우() {
    	assertSimpleTest(() -> 
    	assertThatThrownBy(() -> runException("pobi","1"))
    	.isInstanceOf(IllegalArgumentException.class)
    			);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
