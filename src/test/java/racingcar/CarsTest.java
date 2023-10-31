package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;

public class CarsTest {

    @Test
    @DisplayName("자동차의 각 이름을 리턴하는 기능테스트")
    void testGetNames() {
        String playerInput = "pobi,woni,kibum";
        Cars cars = new Cars(playerInput);

        List<String> names = cars.getNames();
        List<String> expected = Arrays.asList("pobi", "woni", "kibum");

        assertThat(names).containsAll(expected);
    }
}
