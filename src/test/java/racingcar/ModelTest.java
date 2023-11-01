package racingcar;

import Model.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ModelTest {

    @Test
    void testCarCreation() {
        Car car = new Car("pobi");

        String name = car.getName();
        int position = car.getPosition();

        assertThat(name).isEqualTo("pobi");
        assertThat(position).isEqualTo(0);
    }

    @Test
    void testCarPositionMove() {
        Car car = new Car("pobi");

        car.changePosition(3);
        int position1 = car.getPosition();

        car.changePosition(4);
        int position2 = car.getPosition();

        assertThat(position1).isEqualTo(0);
        assertThat(position2).isEqualTo(1);
    }

    @Test
    void testRaceCreation() {
        List<String> name = Arrays.asList("pobi","woni");
        Race race = new Race(name);

        assertThat(name.size()).isEqualTo(race.getCars().size());

        for (int i = 0; i < name.size(); i++) {
            assertThat(name.get(i)).isEqualTo(race.getCars().get(i).getName());
        }
    }

    @Test
    void testRacePositionMove() {
        List<String> name = Arrays.asList("pobi","woni");
        Race race = new Race(name);

        race.playRound();
        for (int i = 0; i < name.size(); i++) {
            assertThat(1).isEqualTo(race.getCars().get(i).getPosition());
        }
    }

    @Test
    void testMaxPositionReturn() {
        List<String> name = Arrays.asList("pobi","woni","jun","han");
        Race race = new Race(name);
        int maxPosition = 0;

        for (int i = 0; i < 5; i++) {
            race.playRound();
        }

        for (Car car : race.getCars()) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }

        race.maxPosition();
        assertThat(maxPosition).isEqualTo(race.getMaxPosition());
    }

    @Test
    void testRaceResult() {
        List<String> name = Arrays.asList("pobi","woni","jun","han");
        Race race = new Race(name);
        List<String> winner = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            race.playRound();
        }
        for (Car car : race.getCars()) {
            if (race.getMaxPosition() == car.getPosition()) {
                winner.add(car.getName());
            }
        }

        assertThat(race.getWinner()).isEqualTo(winner);
    }
}
