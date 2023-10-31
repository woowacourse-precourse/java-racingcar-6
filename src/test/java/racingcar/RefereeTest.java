package racingcar;

import java.util.HashMap;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RefereeTest {

    @Test
    @DisplayName("우승자는 한명이다.")
    void choiceWinners_one() {
        HashMap<String, Integer> cars = new HashMap<>();
        cars.put("pobi", 0);
        cars.put("woni", 3);

        Referee referee = new Referee();

        List<String> winner = referee.choiceWinners(cars);

        Assertions.assertThat(winner).contains("woni");
        Assertions.assertThat(winner.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("우승자가 여러 명이다.")
    void choiceWinners_many() {
        HashMap<String, Integer> cars = new HashMap<>();
        cars.put("pobi", 0);
        cars.put("woni", 3);
        cars.put("jun", 3);

        Referee referee = new Referee();

        List<String> winner = referee.choiceWinners(cars);

        Assertions.assertThat(winner).contains("woni", "jun");
        Assertions.assertThat(winner.size()).isEqualTo(2);
    }
}