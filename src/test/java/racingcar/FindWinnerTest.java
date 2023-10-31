package racingcar;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FindWinnerTest {
    @Test
    void 우승_전진횟수_계산() {
        List<Car> carList = new ArrayList<>();

        Car pobi = new Car("pobi");
        pobi.moveForward();
        pobi.moveForward();
        pobi.moveForward(); //pobi의 점수 : 3

        Car woni = new Car("woni");
        woni.moveForward();
        woni.moveForward(); //woni의 점수 : 2

        Car jun = new Car("jun");
        jun.moveForward();
        jun.moveForward();
        jun.moveForward(); //jun의 점수 : 3

        carList.add(pobi);
        carList.add(woni);
        carList.add(jun);

        FindWinner findWinner = new FindWinner(carList);

        assertThat(findWinner.getWinningPoint()).isEqualTo(3);
    }
}