package racingcar.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.RacingCar;
import racingcar.model.RacingCars;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingControllerTest {
    private RacingCars init(List<String> names) {
        List<RacingCar> racingCars = new ArrayList<>();
        for(String name : names){
            racingCars.add(RacingCar.from(name));
        }
        return RacingCars.from(racingCars);
    }
    @Test
    void init_정상_이름들을_받으면_같은크기의_RacingCars_생성해서_넘겨준다() {
        List<String> names = new ArrayList<>();
        names.add("pobi");
        names.add("woni");
        names.add("jun");

        RacingCars result = init(names);

        assertThat(result.getRacingCars().size()).isEqualTo(names.size());
    }

}