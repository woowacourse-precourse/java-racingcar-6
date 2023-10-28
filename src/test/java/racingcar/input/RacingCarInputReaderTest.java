package racingcar.input;

import static org.junit.jupiter.api.Assertions.*;
import static racingcar.input.RacingCarInputReader.RACING_CAR_INPUT_SPLITTER;
import static racingcar.input.RacingCarInputReader.makeRacingCarMap;

import java.util.ArrayList;
import java.util.Map;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import racingcar.service.RacingCar;

class RacingCarInputReaderTest {

    @Test
    public void makeRacingCarMap_test() {
        // given
        String input = "test1,test2,test3";
        ArrayList<String> names = Lists.newArrayList(input.split(RACING_CAR_INPUT_SPLITTER));
        // when
        Map<String, RacingCar> result = makeRacingCarMap(input);

        // then
        result.forEach((key, value) -> {
            assertTrue(names.contains(key));
            assertEquals(key, value.name());
            assertEquals(value.advanceDistance(), 0);
        });
    }
}