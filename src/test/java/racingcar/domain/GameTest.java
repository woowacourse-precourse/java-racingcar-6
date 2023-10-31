package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void 경주차의_이동거리에_알맞은_우승자선정() {
        ArrayList<Car> carList = new ArrayList<>();
        carList.add(new Car("a"));
        carList.add(new Car("b"));
        carList.add(new Car("c"));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j <= i; j++)
                carList.get(i).move();
        }

        // a,0
        // b,1
        // c,2

        Game game = new Game(carList, 3);
        StringBuilder result = game.decideWinner();

        assertThat(String.valueOf(result)).isEqualTo("c");
    }

}