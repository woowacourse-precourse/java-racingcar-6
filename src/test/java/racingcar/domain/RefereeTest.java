package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class RefereeTest {

    @Test
    void showWinnerTest1() {
        Referee referee = new Referee();

        List<Car> carList = new ArrayList<>();
        carList.add(new Car("Jimi"));
        carList.add(new Car("James"));
        carList.add(new Car("Moo"));
        carList.get(0).carPosition = 4;
        carList.get(1).carPosition = 5;
        carList.get(2).carPosition = 7;
        String result = referee.showWinner(carList);
        assertThat(result).isEqualTo("최종 우승자 : Moo");
    }

    @Test
    void showWinnerTest2() {
        Referee referee = new Referee();

        List<Car> carList = new ArrayList<>();
        carList.add(new Car("Jimi"));
        carList.add(new Car("James"));
        carList.add(new Car("Moo"));
        carList.get(0).carPosition = 5;
        carList.get(1).carPosition = 4;
        carList.get(2).carPosition = 2;
        String result = referee.showWinner(carList);
        assertThat(result).isEqualTo("최종 우승자 : Jimi");
    }

    @Test
    void showWinnerTest3() {
        Referee referee = new Referee();

        List<Car> carList = new ArrayList<>();
        carList.add(new Car("Jimi"));
        carList.add(new Car("James"));
        carList.add(new Car("Moo"));
        carList.get(0).carPosition = 12;
        carList.get(1).carPosition = 18;
        carList.get(2).carPosition = 4;
        String result = referee.showWinner(carList);
        assertThat(result).isEqualTo("최종 우승자 : James");
    }
}