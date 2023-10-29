package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest2 extends NsTest {
    @Test
    void 전진_정지2() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,coke", "1");
                    assertThat(output()).contains("pobi : -", "woni : ","coke : -", "최종 우승자 : pobi, coke");
                },
                4, 3 , 6
        );
    }
    @Test
    void 이름이_5글자_초과(){
        assertSimpleTest(()->
            assertThatThrownBy(()->runException("apple,banana,pineapple","5"))
                    .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 동일한_이름_존재(){
        assertSimpleTest(()->
                assertThatThrownBy(()->runException("apple,pen,apple","5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}