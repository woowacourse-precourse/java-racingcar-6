package racingcar.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RaceTest {
    @Test
    public void is_not_finish() {
        //given
        List<String> carNameList = new ArrayList<>(List.of("a", "b", "c"));
        Race race = new Race(5,carNameList);

        //when
        race.runRace();

        //then
        Assertions.assertThat(race.isFinish()).isFalse();

    }

    @Test
    public void is_finish() {
        //given
        List<String> carNameList = new ArrayList<>(List.of("a", "b", "c"));
        Race race = new Race(1,carNameList);

        //when
        race.runRace();

        //then
        Assertions.assertThat(race.isFinish()).isTrue();

    }

    @Test
    public void make_car_name_list() {
        // given
        List<String> carNameList = new ArrayList<>(List.of("a", "b", "c"));
        Race race = new Race(1, carNameList);

        // when
        List<String> getCarNameList = race.makeCarNameList();

        //then
        Assertions.assertThat(getCarNameList).isEqualTo(carNameList);

    }

    @Test
    public void make_car_drive_count_list() {
        // given
        List<String> carNameList = new ArrayList<>(List.of("a", "b", "c"));
        Race race = new Race(1, carNameList);
        List<Integer> carDriveCountList = new ArrayList<>(List.of(0, 0, 0));

        // when
        List<Integer> getDriveCountList = race.makeCarDriveCountList();

        // then
        Assertions.assertThat(getDriveCountList).isEqualTo(carDriveCountList);
    }

    @Test
    public void find_winner() {
        assertRandomNumberInRangeTest(
                () -> {
                    Assertions.assertThat(run_race().get(0)).isEqualTo("a");
                },
                9, 0, 0, 8, 3, 2
        );
    }

    private List<String> run_race() {
        List<String> carNameList = new ArrayList<>(List.of("a", "b", "c"));
        Race race = new Race(2, carNameList);
        race.runRace();
        return race.findWinner();
    }


}
