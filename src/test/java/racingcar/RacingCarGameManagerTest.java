package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarGameManagerTest extends NsTest {

    private static final String RESULT_PRINT_MESSAGE = "실행 결과";
    private static final List<String> CAR_NAME = Arrays.asList("yujin", "minji", "zion");

    @BeforeEach
    void setUp() {
        CarInfoManager.initializeCarInfos(CAR_NAME);
    }

    @Test
    void 실행_결과_출력_메세지() {
        runMain();
        assertThat(output()).contains(RESULT_PRINT_MESSAGE);
    }

    @Test
    void 시도_횟수만큼_반복하며_전진_및_출력() {
        AtomicReference<String> str = new AtomicReference<>("");
        runMain();
        CarInfoManager.carInfos.stream()
                        .forEach(
                                car -> {
                                    String s = str.get();
                                    s += car.getName() + " : " + "-".repeat(car.getPosition());
                                    str.set(s);
                                }
                        );
        assertThat(output()).contains(str.get());
    }

    @Test
    void 최종_우승자_출력_메세지() {
        runMain();
        assertThat(output().contains("최종 우승자 : "));
    }

    @Override
    protected void runMain() {
        RacingCarGameManager.start();
    }
}