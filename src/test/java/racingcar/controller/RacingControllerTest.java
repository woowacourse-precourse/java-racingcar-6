package racingcar.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.GONumberGenerator;
import racingcar.model.NumberGenerator;
import racingcar.model.RacingCar;
import racingcar.model.RacingCars;
import racingcar.util.Constants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingControllerTest {
    private RacingCars init(List<String> names) {
        List<RacingCar> racingCars = new ArrayList<>();
        for (String name : names) {
            racingCars.add(RacingCar.from(name));
        }
        return RacingCars.from(racingCars);
    }
    public List<RacingCar> getMaxs(RacingCars racingCars) {
        int max= Constants.RANDOM_NUM_START;
        HashMap<Integer, List<RacingCar>> map = new HashMap<>();

        for (RacingCar car : racingCars.getRacingCars()) {
            max = Math.max(car.getDistance(), max);
            if(map.containsKey(car.getDistance())){
                List<RacingCar> values = map.get(car.getDistance());
                values.add(car);
                map.put(car.getDistance(), values);
                continue;
            }
            List<RacingCar> values = new ArrayList<>();
            values.add(car);
            map.put(car.getDistance(), values);
        }
        return map.get(max);
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

    @Test
    void getMaxs_정상동작_테스트(){
        //given
        NumberGenerator numberGenerator = new GONumberGenerator();
        List<RacingCar> list = new ArrayList<>();
        RacingCar car1 = RacingCar.from("jun");
        car1.move(numberGenerator);
        car1.move(numberGenerator);
        RacingCar car2 = RacingCar.from("woni");
        car2.move(numberGenerator);
        RacingCar car3 = RacingCar.from("pobi");
        car3.move(numberGenerator);
        list.add(car1);
        list.add(car2);
        list.add(car3);
        RacingCars racingCars = RacingCars.from(list);
        //when
        List<RacingCar> winners = getMaxs(racingCars);
        //then
        assertThat(winners.size()).isEqualTo(1);
        assertThat(winners.get(0).getName()).isEqualTo("jun");

    }
}