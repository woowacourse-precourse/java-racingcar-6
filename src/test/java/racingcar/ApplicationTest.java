package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;
import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.utils.Validation.*;

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
    @DisplayName("자동차 이름 입력 시 콤마를 사용해 나누었는지 확인")
    void 콤마_사용_여부_확인() {
        String carsString = "pobijava";
        assertThatThrownBy(() -> validateNoComma(carsString))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("자동차 이름 입력 시 중복된 이름이 있는지 확인")
    void 이름_중복_여부_확인() {
        String[] carsString = {"pobi","pobi","java"};
        assertThatThrownBy(() -> validateSameName(carsString))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("자동차 이름 길이가 1글자 이상 5글자 이하인지 확인")
    void 자동차_이름_글자수_확인() {
        String[] carsString = {"pobi","pobi","pororo"};
        assertThatThrownBy(() -> validateNameLength(carsString))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("시도 회수에 자연수를 입력했는지 확인")
    void 자연수_여부_확인() {
        String input = "0";
        assertThatThrownBy(() -> validateNaturalNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("자동차 움직임 여부 확인")
    void 자연수_이동_확인() {
        Car car = new Car("pobi");
        car.PlusScore();
        assertThat(car.getPosition()==0 || car.getPosition()==1);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
