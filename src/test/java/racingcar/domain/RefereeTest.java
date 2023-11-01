package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RefereeTest {

    @Test
    public void 입력한_실행_횟수가_판단_기준보다_크다() {
        Referee referee = new Referee();

        assertThat(referee.isGreaterThanEqual(9)).isTrue();
        assertThat(referee.isGreaterThanEqual(8)).isTrue();
        assertThat(referee.isGreaterThanEqual(2)).isFalse();
    }

    @Test
    public void 우승자를_판별한다() {
        List<Car> carList = Arrays.asList(
                new Car("Car1"),
                new Car("Car2"),
                new Car("Car3")
        );

        carList.get(0).go();
        carList.get(0).go();
        carList.get(0).go();

        carList.get(1).go();
        carList.get(1).go();
        carList.get(1).go();

        carList.get(2).go();

        Referee referee = new Referee();
        List<String> result = referee.judgeWinner(carList);
        List<String> expected = List.of("Car1", "Car2");

        Assertions.assertThat(result).isEqualTo(expected);
    }
}
