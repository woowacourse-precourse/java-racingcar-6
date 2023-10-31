package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class JudgmentTest {

    @Test
    void findMaxPosition_메서드로_자동차들의_위치의_최대값을_반환(){
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("pobi", 0));
        carList.add(new Car("woni", 2));
        carList.add(new Car("jun", 5));
        carList.add(new Car("lisa", 5));
        Judgment judgment = new Judgment();

        int actual = judgment.findMaxPosition(carList, 6);

        assertThat(actual).isEqualTo(5);
    }
}
