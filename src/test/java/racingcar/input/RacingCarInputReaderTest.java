package racingcar.input;

import static org.junit.jupiter.api.Assertions.*;
import static racingcar.input.RacingCarInputReader.RACING_CAR_INPUT_SPLITTER;
import static racingcar.input.RacingCarInputReader.makeRacingCarList;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import racingcar.service.RacingCar;

class RacingCarInputReaderTest {

    @Test
    public void makeRacingCarList_test() {
        // given
        String input = "test1,test2,test3";
        ArrayList<String> names = Lists.newArrayList(input.split(RACING_CAR_INPUT_SPLITTER));
        // when
        List<RacingCar> result = makeRacingCarList(input);

        // then
        result.forEach(value -> assertTrue(names.contains(value.getName())));
    }
}