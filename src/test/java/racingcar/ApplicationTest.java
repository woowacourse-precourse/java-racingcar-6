package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    
    @Test
    void 이름에_대한_예외_처리() {
       assertSimpleTest(() -> assertThatThrownBy(() -> runException("pobi,javaji", "1"))
             .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 라운드수에_대한_예외_처리() {
       assertSimpleTest(() -> assertThatThrownBy(() -> runException("pobi,java", "하나"))
             .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 레이싱_결과추출에_대한_확인() {
       assertRandomNumberInRangeTest(() -> {
          run("pobi,woni", "1");
          assertThat(output()).contains("최종 우승자 : ");
       }, 1);
    }
    
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
