package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.InputView.InputView;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private InputView inputView;

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

    @BeforeEach
    public void setup() {
        inputView = new InputView();
    }

    @Test
    public void 자동차_이름_예외_처리() {
        String input = "pobi,woni,jun";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        List<String> carNames = inputView.getCarNames();

        List<String> expectedCarNames = Arrays.asList("pobi", "woni", "jun");
        assertEquals(expectedCarNames, carNames);
    }

    @Test
    public void 게임시도_회수_예외_처리() {
        String input = "3";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        int result = inputView.getRoundNumber();
        assertEquals(3, result);
;    }

    @Test
    public void 게임시도_회수_공백_예외_처리() {
        String input = " ";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertThrows(IllegalArgumentException.class, () -> inputView.getRoundNumber());
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
