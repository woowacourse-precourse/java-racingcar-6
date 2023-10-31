package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RaceTest {
    private Cars testCars;

    @BeforeEach
    void setUp() {
        String testCarName1 = "pobi";
        String testCarName2 = "woni";

        Car testCar1 = new Car(testCarName1);
        Car testCar2 = new Car(testCarName2);

        testCars = new Cars(new ArrayList<>(List.of(testCar1, testCar2)));
    }

    @Test
    void 경주_생성_테스트() {
        Race race = new Race(testCars, () -> true);

        assertThat(race).isNotNull();
        assertThat(testCars.getCars().get(0).getName()).isEqualTo("pobi");
        assertThat(testCars.getCars().get(1).getName()).isEqualTo("woni");
    }

    @Test
    void 경주_한_라운드_진행_테스트() {
        Race race = new Race(testCars, () -> true);
        race.executeOneRound();

        assertThat(testCars.getCars().get(0).getPosition()).isEqualTo(1);
        assertThat(testCars.getCars().get(1).getPosition()).isEqualTo(1);
    }

    @Test
    void 자동차_목록_반환_테스트() {
        Race race = new Race(testCars, () -> true);
        List<Car> cars = race.getCars();

        assertThat(cars.size()).isEqualTo(2);
        assertThat(cars.get(0)).isEqualTo(testCars.getCars().get(0));
        assertThat(cars.get(1)).isEqualTo(testCars.getCars().get(1));
        assertThat(cars.get(0).getName()).isEqualTo("pobi");
        assertThat(cars.get(1).getName()).isEqualTo("woni");
    }

    @Test
    void 우승자_목록_반환_테스트() {
        Race race = new Race(testCars, () -> true);
        race.executeOneRound();
        List<String> winners = race.getWinnerNames();

        assertThat(winners.size()).isEqualTo(2);
        assertThat(winners.get(0)).isEqualTo("pobi");
        assertThat(winners.get(1)).isEqualTo("woni");
    }
}