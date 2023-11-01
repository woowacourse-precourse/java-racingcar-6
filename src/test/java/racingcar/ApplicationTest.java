package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.LinkedHashMap;
import java.util.Map;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private static Map<String, Integer> rightCarDistanceMap() {

        Map<String, Integer> rightCarDistanceMap = new LinkedHashMap<>() {
            {
                put("car1", 0);
                put("car2", 0);
            }
        };

        return rightCarDistanceMap;
    }

    private static String[] rightCarNames = "car1,car2".split(",");

    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP);
    }

    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 입력받은_차_나눠서_MAP으로_만들기() {

        Map<String, Integer> rightCarDistanceMap = rightCarDistanceMap();

        String[] mapKeys = new String[] { "1", "2" };
        int i = 0;
        for (Map.Entry<String, Integer> mapEntry : rightCarDistanceMap.entrySet()) {
            assertThat(rightCarNames).contains(mapEntry.getKey());
            mapKeys[i] = mapEntry.getKey();
            i++;
        }
        assertThat(rightCarNames).containsExactly(mapKeys);
    }

    @Test
    void 입력값_중_5이상의_단어가_있으면_EXCEPTION_발생() {
        String carNames = "car1, carcar2, car3";

        assertThatThrownBy(() -> Application.carDistanceMap(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 반복횟수_0이하_EXCEPTION_발생() {
        int repeatCount = -1;
        assertThatThrownBy(() -> Application.startRacing(null, repeatCount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 최종결과_확인() {

        Map<String, Integer> rightCarDistanceMap = rightCarDistanceMap();

        rightCarDistanceMap.put("car1", 2);
        String winner = Application.getWinner(rightCarDistanceMap);

        assertThat("car1").contains(winner);

        rightCarDistanceMap.put("car2", 2);
        String winners = Application.getWinner(rightCarDistanceMap);

        assertThat("car1, car2").contains(winners);
    }

    @Test
    void 레이싱_출력값_확인() {

        Map<String, Integer> rightCarDistanceMap = rightCarDistanceMap();

        rightCarDistanceMap.put("car1", 1);
        rightCarDistanceMap.put("car2", 2);

        PrintStream originalOut = System.out;
        String capturedOutput;

        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            PrintStream printStream = new PrintStream(outputStream);

            System.setOut(printStream);

            Application.printResult(rightCarDistanceMap);

            capturedOutput = outputStream.toString();

        } finally {

            System.setOut(originalOut);

        }

        assertThat(capturedOutput).contains("car1 : -", "car2 : --");
    }

    @Override
    public void runMain() {
        Application.main(new String[] {});
    }
}
