package racingcar.ErrorTest;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import racingcar.Model.Car;

public class CarsTest extends NsTest {
    @Test
    void 중복에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 빈_리스트_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(Collections.emptyList()))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    private <T> void runException(List<Car> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("빈 리스트는 처리할 수 없습니다.");
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
