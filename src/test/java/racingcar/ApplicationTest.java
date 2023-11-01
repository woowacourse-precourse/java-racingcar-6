package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.domain.Leaderboard;
import racingcar.domain.NamesManager;
import racingcar.domain.RoundNumberManager;

import java.util.Arrays;
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
    void 이름_분리(){
        NamesManager manager = new NamesManager();
        List<String> nameList = manager.separateNamesString("pobi,woni,jun");
        assertThat(nameList).isEqualTo(Arrays.asList("pobi","woni","jun"));
    }

    @Test
    void 이름_길이_검사(){
        NamesManager manager = new NamesManager();
        boolean result = manager.wrongNameLength("javaji");
        assertThat(result).isEqualTo(true);
    }

    @Test
    void 이름_중복_검사(){
        NamesManager manager = new NamesManager();
        boolean result = manager.duplicateName(Arrays.asList("pobi","pobi"));
        assertThat(result).isEqualTo(true);
    }

    @Test
    void 이름_종합_검사(){
        NamesManager manager = new NamesManager();
        boolean result = manager.checkNamesException(Arrays.asList("pobi","pobiiii"));
        assertThat(result).isEqualTo(true);
    }

    @Test
    void 우승자_안내_문구_생성(){
        Leaderboard board = new Leaderboard(Arrays.asList(""));
        String result = board.winnerFormat(Arrays.asList("Kim","Jin","Yi"));
        assertThat(result).isEqualTo("최종 우승자 : Kim, Jin, Yi");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
