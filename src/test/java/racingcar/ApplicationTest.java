package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.ByteArrayInputStream;
import java.util.*;

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
    void 해쉬맵_생성_및_갱신() {
        ArrayList<String> testList = new ArrayList<>(Arrays.asList("user1", "user2", "user3"));

        HashMap<String, String> testMap = Application.makeHashMap(testList);

        for (String user : testList) {
            assertTrue(testMap.get(user).length() < 3); 
        }
    }

    @Test
    void 경기_횟수_음수입력() {
        System.setIn(new ByteArrayInputStream("-1".getBytes()));
        assertThatThrownBy(() -> Application.isNumberInput())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("음수가 입력되었습니다.");

    }

    @Test
    void 레이싱_시뮬레이션() {
        ArrayList<String> testList = new ArrayList<>(Arrays.asList("user1", "user2", "user3"));

        ArrayList<String> winners = Application.startRacing(testList, 3);
    
        assertTrue(testList.containsAll(winners));

    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
