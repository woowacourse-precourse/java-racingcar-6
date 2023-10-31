package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.domain.Referee;
import racingcar.domain.Car;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
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
    void 자동차_이름_일치() {
        Referee referee = null;
        List<String> result = new ArrayList<>();

        try {
            final byte[] buf = String.join("\n", "Unity,Chan,Kawai", "7").getBytes();
            System.setIn(new ByteArrayInputStream(buf));
            referee = new Referee();
        } finally {
            Console.close();
        }

        for (Car car : referee.getCarList()) {
            result.add(car.getName());
        }
        assertThat(result).containsExactly("Unity", "Chan", "Kawai");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
