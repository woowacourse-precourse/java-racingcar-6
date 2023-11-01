package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    
    @Test
    void 객체_생성_확인() {
        String inputCarNames = "A,B,C";
        String[] splitCarNames = inputCarNames.split(",");
        Car[] carObjectsArray = new Car[splitCarNames.length];
        for (int i = 0; i < splitCarNames.length; i++) {
            HandleException.carName(splitCarNames[i]);
            carObjectsArray[i] = new Car(splitCarNames[i]);
        }
        
        assertThat(carObjectsArray.length).isEqualTo(3);
        assertThat(carObjectsArray[0].getName()).isEqualTo("A");
        assertThat(carObjectsArray[1].getName()).isEqualTo("B");
        assertThat(carObjectsArray[2].getName()).isEqualTo("C");
    }
    
    @Test
    void 횟수_변환_확인() {
        String inputTimes = "5";
        int timesValue = HandleException.times(inputTimes);
        assertThat(timesValue).isEqualTo(5);
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
    void 공동_우승자() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi, woni");
            },
            MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"a", "1a", "1.1", "0", "-1"})
    void 횟수에_대한_예외_처리(String times) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", times))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
