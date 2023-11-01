package racingcar.race;

import org.junit.jupiter.api.Test;
import racingcar.car.RandomNumberGenerator;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceTest {
    @Test
    void Race는_자동차를_추가할_수_있다(){
        // given
        RandomNumberGenerator forwardGenerator = ()->4;
        RandomNumberGenerator stayGenerator = ()->3;
        Race race = new Race();

        // when
        race.addCar("Car1", forwardGenerator);
        race.addCar("Car2", stayGenerator);

        // then
        assertThat(race.getCars()).hasSize(2);
    }

    @Test
    void Race는_모든_차를_한번에_움직일_수_있다(){
        // given
        RandomNumberGenerator forwardGenerator = ()->4;
        Race race = new Race();
        race.addCar("Car1", forwardGenerator);
        race.addCar("Car2", forwardGenerator);

        // when
        race.moveCars();

        // then
        assertThat(race.getCars().get(0).getLocation()).isEqualTo(1);
        assertThat(race.getCars().get(1).getLocation()).isEqualTo(1);
    }

    @Test
    void Race는_모든_자동차들의_위치를_알려준다(){
        // given
        RandomNumberGenerator forwardGenerator = ()->4;
        Race race = new Race();
        race.addCar("Car1", forwardGenerator);
        race.addCar("Car2", forwardGenerator);
        for(int i =0; i < 4; i++){
            race.getCars().get(0).move();
        }
        for(int i =0; i < 5; i++){
            race.getCars().get(1).move();
        }

        // when
        Map<String, Integer> raceResult = race.getEachCarNameAndLocation();

        // then
        assertThat(raceResult).containsEntry("Car1",4);
        assertThat(raceResult).containsEntry("Car2",5);
    }
    @Test
    void Race는_가장_빠른_차를_알려준다(){
        // given
        RandomNumberGenerator forwardGenerator = ()->4;
        Race race = new Race();
        race.addCar("Car1", forwardGenerator);
        race.addCar("Car2", forwardGenerator);
        race.addCar("Car3", forwardGenerator);
        for(int i =0; i < 4; i++){
            race.getCars().get(0).move();
        }
        for(int i =0; i < 5; i++){
            race.getCars().get(1).move();
            race.getCars().get(2).move();
        }

        // when
        List<String> fastestCars = race.getFastestCarNames();

        // then
        assertThat(fastestCars).hasSize(2);
        assertThat(fastestCars.get(0)).isEqualTo("Car2");
        assertThat(fastestCars.get(1)).isEqualTo("Car3");
    }
}
