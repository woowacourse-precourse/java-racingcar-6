package racingcar;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.groups.Tuple.tuple;

public class RacingCarTest {
    @Test
    void RacingCar_객체_생성() {
        List<RacingCar> result = new ArrayList<>();
        RacingCar racingCar1 = new RacingCar("junho", 0);
        RacingCar racingCar2 = new RacingCar("bang", 0);
        RacingCar racingCar3 = new RacingCar("kim", 0);
        result.add(racingCar1);
        result.add(racingCar2);
        result.add(racingCar3);
        assertThat(result).filteredOn("count", 0).containsOnly(racingCar1, racingCar2, racingCar3);
        assertThat(result).extracting("name", "count")
                .contains(tuple("junho", 0));
    }
}
