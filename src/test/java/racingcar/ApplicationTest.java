package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
    void 자동차_객체_생성_테스트(){
        Racingcar car = new Racingcar("TEST");

        for (int i = 0; i < 10; i++){
            car.upMoveDistance();
        }

        assertThat(car.getName()).isEqualTo("TEST");
        assertThat(car.getMoveDistance()).isEqualTo(10);
    }

    @Test
    void 이름_갯수에_대한_예외처리(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("123,ABC", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 쉼표_기준으로_Split_함수_테스트(){
        List<String> names;
        MakeNames makeNames = new MakeNames();

        names = makeNames.commaSplit("123,abc,ABC");

        assertThat(names).isEqualTo(new ArrayList<>(Arrays.asList("123","abc","ABC")));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
