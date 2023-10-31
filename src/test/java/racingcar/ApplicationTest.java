package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.domain.Judgement;
import racingcar.domain.NumberGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;


    @Test
    void 무승부_판별(){
        final Judgement judgement = new Judgement();
        List<String> names = new ArrayList<>();
        names.add("pobi");
        names.add("woni");
        Map<String,String> users = new HashMap<>();
        users.put("pobi","--");
        users.put("woni","--");

        List<String> result = judgement.compareDistance(users,names);

        assertThat(result).isEqualTo(names);
    }
    @Test
    void 숫자_생성(){
        final NumberGenerator numberGenerator = new NumberGenerator();
        boolean result = (numberGenerator.createRandomNumber() >= 0)&&(numberGenerator.createRandomNumber() <= 9);
        assertThat(result).isEqualTo(true);
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
