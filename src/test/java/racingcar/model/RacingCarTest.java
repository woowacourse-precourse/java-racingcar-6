package racingcar.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import racingcar.Application;

public class RacingCarTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    RacingCarService service = new RacingCarService();

    @Test
    void 자동차_레이싱_작동_성공() {
        String carNames = "a,b,c";
        int tryNumber = 5;

        Map<String, List<Integer>> carMap = service.raceCar(carNames, tryNumber);
        System.out.println(carMap);
    }

    @Test
    void 자동차_레이싱_결과값_변환_성공() {
        String carNames = "a,b,c";
        String userInputTryNumber = "10";

        Map<String, List<String>> translatedResult = service.translateResult(carNames, userInputTryNumber);
        System.out.println(translatedResult);
    }

    @Test
    void 자동차_레이싱_결과_정상_출력_확인() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
