package racingcar;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckerTest {
    @Test
    void 이름이_5자_초과일_경우_false_리턴() {
        List<String> correctNames = Arrays.asList("name1", "name");
        List<String> incorrectNames = Arrays.asList("incorrect", "name2");

        assertThat(Checker.isNameAllCorrect(correctNames)).isTrue();
        assertThat(Checker.isNameAllCorrect(incorrectNames)).isFalse();
    }

    @Test
    void score가_가장_높은_car의_이름_리턴() {
        List<Car> cars = Arrays.asList(new Car("car1", 3), new Car("car2", 3), new Car("car3", 1));
        List<String> winners = Checker.judgeWinners(cars);

        assertThat(winners.size()).isEqualTo(2);
        assertThat(winners.contains("car1")).isTrue();
        assertThat(winners.contains("car2")).isTrue();
    }
}
