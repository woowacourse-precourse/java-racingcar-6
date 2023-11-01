package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.objenesis.instantiator.basic.NewInstanceInstantiator;
import racingcar.domain.NumberGenerator;
import racingcar.domain.Race;

import java.util.Map;

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
    void 랜덤_숫자_추출() {
        int minNum = 0;
        int maxNum = 9;
        boolean checkRandomNumFlag;

        int randomNumberInRange = NumberGenerator.getRandomNumberInRange(minNum, maxNum);

        if (randomNumberInRange >= minNum && randomNumberInRange <= maxNum) {
            checkRandomNumFlag = true;
        } else {
            checkRandomNumFlag = false;
        }

        // 범위 내에 있는 숫자이면 통과
        Assertions.assertTrue(checkRandomNumFlag);
    }

    @Test
    void 입력한_자동차_이름_저장() {
        String inputCarNameString = "car1,car2,car3";

        Race race = new Race();
        Map<String, String> carMap = race.saveCarMap(inputCarNameString);

        Assertions.assertEquals(3, carMap.size());
        Assertions.assertEquals("", carMap.get("car1"));
        Assertions.assertEquals("", carMap.get("car2"));
        Assertions.assertEquals("", carMap.get("car3"));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
