package mytest;


import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import racingcar.RacingInfo;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingInfoTest extends NsTest {
    @Test
    void setNamesAndNum_차량이름_시도횟수_예외처리(){
        // 이름을 5글자를 초과하여 적은 경우
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("jiji,min,minjung"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        // 횟수가 음수로 입력될 경우
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("jiji,min,minji", "-5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void getNum_입력된_시도횟수_반환(){
        assertSimpleTest(
                () -> {
                    run("jiji,minji", "2");
                    assertThat(RacingInfo.getNum()).isEqualTo(2);
                }
        );
    }

    @Test
    void getNames_입력된_차량이름_반환(){
        String[] result = {"jiji", "minji"};
        assertSimpleTest(
                () -> {
                    run("jiji,minji", "2");
                    assertThat(RacingInfo.getNames()).isEqualTo(result);
                }
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
