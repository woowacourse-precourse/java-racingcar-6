package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class RaceEntryTest {
    @Test
    void 레이스_엔트리_테스트() {
        List<String> names = Arrays.asList("aaa", "bbb", "ccc", "ddd");
        RaceEntry raceEntry = new RaceEntry(names);
        List<Car> entryList = raceEntry.getRaceEntryList();

        Assertions.assertThat(entryList.size()).isEqualTo(4);

        for (Car car : entryList) {
            Assertions.assertThat(names).contains(car.getName());
        }

    }

}
