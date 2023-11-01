package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RaceTest {
    @Test
    public void isNotFinish() {
        //given
        List<String> carNameList = new ArrayList<>(List.of("a", "b", "c"));
        Race race = new Race(5,carNameList);

        //when
        race.runRace();

        //then
        Assertions.assertThat(race.isFinish()).isFalse();

    }

    @Test
    public void isFinish() {
        //given
        List<String> carNameList = new ArrayList<>(List.of("a", "b", "c"));
        Race race = new Race(1,carNameList);

        //when
        race.runRace();

        //then
        Assertions.assertThat(race.isFinish()).isTrue();

    }

    @Test
    public void makeCarNameList() {
        // given
        List<String> carNameList = new ArrayList<>(List.of("a", "b", "c"));
        Race race = new Race(1, carNameList);

        // when
        List<String> getCarNameList = race.makeCarNameList();

        //then
        Assertions.assertThat(getCarNameList).isEqualTo(carNameList);

    }


}
