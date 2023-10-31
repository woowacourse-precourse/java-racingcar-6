package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JudgmentTest {
    private List<Car> carList;
    private Judgment judgment;

    @BeforeEach
    void setUp() {
        carList = new ArrayList<>();
        carList.add(new Car("pobi", 0));
        carList.add(new Car("woni", 2));
        carList.add(new Car("jun", 5));
        carList.add(new Car("lisa", 5));
        judgment = new Judgment();
    }

    @Test
    void findMaxPosition_메서드로_자동차들의_위치의_최대값을_반환() {
        int actual = judgment.findMaxPosition(carList);

        assertThat(actual).isEqualTo(5);
    }

    @Test
    void getWinnerNames_메서드로_최대위치값을_가진_자동차들의_이름을_반환() {
        List<String> actual = judgment.getWinnerNames(carList, 5);

        assertThat(actual).containsExactly("jun", "lisa");
    }
}
