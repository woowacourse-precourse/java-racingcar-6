package racingcar;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class GameTest {

    @Test
    void get_우승자_리스트_1명() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("pobi", 2));
        carList.add(new Car("woni", 1));
        carList.add(new Car("jun", 5));
        carList.add(new Car("honi", 10));

        Game game = new Game(carList, 0);
        List<String> winnerList = game.getWinnerList();

        List<String> resultList = new ArrayList<>();
        resultList.add("honi");

        assertThat(winnerList).isEqualTo(resultList);
    }

    @Test
    void get_우승자_리스트_2명_이상() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("pobi", 5));
        carList.add(new Car("woni", 1));
        carList.add(new Car("jun", 5));
        carList.add(new Car("honi", 5));

        Game game = new Game(carList, 0);
        List<String> winnerList = game.getWinnerList();

        List<String> resultList = new ArrayList<>();
        resultList.add("pobi");
        resultList.add("jun");
        resultList.add("honi");

        assertThat(winnerList).isEqualTo(resultList);
    }
}