package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class RaceTest {
    private static List<String> input;

    @BeforeAll
    static void setInput() {
        input = new ArrayList<>();
        input.add("harry");
        input.add("ron");
    }

    @Test
    void setCarList_차_리스트_생성() {
        Race race = new Race();
        List<String> cars = new ArrayList<>();

        race.setCarList(input);
        for (Car car : race.getCarList()){
            cars.add(car.getCarName());
        }

        assertThat(cars).isEqualTo(input);
    }

    @Test
    void getRaceResult_레이스_결과_반환() {
        Race race = new Race();
        race.setCarList(input);
        race.setRaceRounds(1);
        race.playOneRound();

        assertThat(race.getRaceResult()).containsAnyElementsOf(input);
    }

}
