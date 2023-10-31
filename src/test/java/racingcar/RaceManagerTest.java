package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class RaceManagerTest {
    private static RaceManager raceManager;

    private class MockCar extends Car {
        public MockCar(String name, String distance) {
            super(name);
            this.distance = new StringBuilder(distance);
        }
    }

    @BeforeAll
    static void beforeAll() {
        raceManager = new RaceManager();
    }

    @Test
    void 우승자를_알려줌() {
        //given
        MockCar winner = new MockCar("winner", "----");
        MockCar nonWinner = new MockCar("nonWinner", "--");
        List<Car> raceCarList = new ArrayList<>() {{
            add(winner);
            add(nonWinner);
        }};

        //when
        List<String> winners = raceManager.determineWinner(raceCarList);

        //then
        assertThat(winners).isEqualTo(List.of(winner.getName()));
    }

    @Test
    void 우승자는_한_명_이상일_수_있음() {
        //given
        MockCar winner1 = new MockCar("winner1", "---");
        MockCar winner2 = new MockCar("winner2", "---");
        List<Car> raceCarList = new ArrayList<>() {{
            add(winner1);
            add(winner2);
        }};

        //when
        List<String> winners = raceManager.determineWinner(raceCarList);

        //then
        assertThat(winners).isEqualTo(List.of(winner1.getName(), winner2.getName()));
    }
}