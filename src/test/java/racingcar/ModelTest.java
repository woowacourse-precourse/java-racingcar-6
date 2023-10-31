package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
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
        int position1 = car.getPosition;

        car.changePosition(4);
        int position2 = car.getPosition;

        assertThat(position).isEqualTo(0);
        assertThat(position).isEqualTo(1);
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
}
