package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.domain.CarInputProcess;
import racingcar.domain.RacingRecord;
import racingcar.domain.RacingResult;
import racingcar.domain.RepeatInputProcess;

import java.util.*;

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
    void 자동차_이름을_쉼표로_구분() {
        CarInputProcess carInputProcess = new CarInputProcess();
        String input = "java,unity";
        List<String> testCars = carInputProcess.process(input);
        assertThat(testCars).contains("java", "unity");
        assertThat(testCars).containsExactly("java", "unity");
    }

    @Test
    void 자동차의_반복_입력값을_숫자_형식으로_표현() {
        RepeatInputProcess repeatInputProcess = new RepeatInputProcess();
        String input = "123";
        int testRepeat = repeatInputProcess.process(input);
        assertThat(testRepeat).isEqualTo(123);
    }

    @Test
    void 자동차의_반복_입력값이_숫자_형식으로_표현되지_않을_때의_예외_처리() {
        RepeatInputProcess repeatInputProcess = new RepeatInputProcess();
        String input = "Java";
        assertSimpleTest(() ->
                assertThatThrownBy(() -> repeatInputProcess.process(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 무작위_값이_4_이상일_경우_전진() {
        RacingRecord racingRecord = new RacingRecord();
        List<String> cars = Arrays.asList("pobi");
        Map<String, Integer> records = new HashMap<>();
        records = racingRecord.initRecord(cars);

        int randomValue = 4;

        for (String car : cars) {
            records = racingRecord.forwardMovement(car, records, randomValue);
        }

        assertThat(records).containsKey("pobi");
        assertThat(records).containsValue(1);
    }

    @Test
    void 사용자의_전진만큼_바_형태로_출력() {
        RacingRecord racingRecord = new RacingRecord();
        List<String> cars = Arrays.asList("pobi", "java");
        Map<String, Integer> records = new HashMap<>();
        records = racingRecord.initRecord(cars);

        int randomValue = 4;

        for (String car : cars) {
            records = racingRecord.forwardMovement(car, records, randomValue);
        }

        racingRecord.printRacingRecord(cars, records);

        assertThat(output()).contains("pobi : -", "java : -");
    }

    @Test
    void 레이싱_전진거리의_최대값을_찾는다() {
        RacingResult racingResult = new RacingResult();
        Map<String, Integer> records = new HashMap<>();
        records.put("pobi",7);
        records.put("java",3);
        int maxDistance = racingResult.findMaximumDistance(records);
        assertThat(maxDistance).isEqualTo(7);
    }

    @Test
    void 우승자가_한_명일_경우_한_명만_출력() {
        RacingResult racingResult = new RacingResult();
        Map<String, Integer> records = new HashMap<>();
        records.put("pobi",7);
        records.put("java",3);
        int maxDistance = racingResult.findMaximumDistance(records);
        List<String> winners = racingResult.findWinners(maxDistance, records);

        assertThat(winners).contains("pobi");
        assertThat(winners).containsExactly("pobi");
    }

    @Test
    void 우승자가_여러_명일_경우_쉼표로_구분하여_출력() {
        RacingResult racingResult = new RacingResult();
        Map<String, Integer> records = new HashMap<>();
        records.put("pobi",7);
        records.put("java",7);
        int maxDistance = racingResult.findMaximumDistance(records);
        List<String> winners = racingResult.findWinners(maxDistance, records);

        assertThat(winners).contains("pobi", "java");
        assertThat(winners).containsExactly("pobi", "java");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
