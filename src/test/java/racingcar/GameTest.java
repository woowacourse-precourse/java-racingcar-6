package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @Test
    void randomNumber_랜덤_넘버가_0부터_9사이에_나오는지_체크() {
        int randomNumber = Game.randomNumber();
        assertTrue(randomNumber >= Game.RANDOM_MIN);
        assertTrue(randomNumber <= Game.RANDOM_MAX);
    }

    @Test
    void checkRandomNumber_랜덤넘버가_4이상인_경우는_true() {
        assertTrue(Game.checkRandomNumber(6));
        assertFalse(Game.checkRandomNumber(2));
    }

    @Test
    void findWinner_단독_우승자_찾기() {
        List<Car> racingCar = new ArrayList<>();
        Car car1 = new Car("car1", 1);
        Car car2 = new Car("car2", 3);
        Car car3 = new Car("car3", 2);

        racingCar.add(car1);
        racingCar.add(car2);
        racingCar.add(car3);

        List<String> winner = Game.findWinner(racingCar);
        Assertions.assertThat(winner).containsExactly("car2");
    }

    @Test
    void findWinner_공동_우승자_찾기() {
        List<Car> racingCar = new ArrayList<>();
        Car car1 = new Car("car1", 1);
        Car car2 = new Car("car2", 3);
        Car car3 = new Car("car3", 3);

        racingCar.add(car1);
        racingCar.add(car2);
        racingCar.add(car3);

        List<String> winner = Game.findWinner(racingCar);
        Assertions.assertThat(winner).containsExactly("car2", "car3");
    }

    @Test
    void printWinner_단독_우승자인_경우() {
        List<String> winnerList = new ArrayList<>();
        winnerList.add("pobi");
        Game.printWinner(winnerList);
        assertThat("최종 우승자 : pobi");
        System.out.println();
    }

    @Test
    void printWinner_공동_우승자인_경우() {
        List<String> winnerList = new ArrayList<>();
        winnerList.add("pobi");
        winnerList.add("jun");
        Game.printWinner(winnerList);
        assertThat("최종 우승자 : pobi, jun");
        System.out.println();
    }
}