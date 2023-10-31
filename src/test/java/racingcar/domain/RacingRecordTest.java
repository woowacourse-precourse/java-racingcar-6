package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingRecordTest {

    private RacingRecord racingRecord;

    @BeforeEach
    void setUp() {
        racingRecord = new RacingRecord();
    }

    @Test
    void 무작위_값이_4_이상일_경우_전진() {
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
        List<String> cars = Arrays.asList("pobi", "java");
        Map<String, Integer> records = new HashMap<>();
        records = racingRecord.initRecord(cars);

        int randomValue = 5;
        for (String car : cars) {
            records = racingRecord.forwardMovement(car, records, randomValue);
        }

        String print = racingRecord.printRacingRecord(cars, records);

        assertThat(print).contains("pobi : -"+ "\n" + "java : -");
    }
}
