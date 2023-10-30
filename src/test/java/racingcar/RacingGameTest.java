package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingGameTest {
    
    @Test
    @DisplayName("컬렉션의 스트림을 통해 콤바로 이름을 구분하고, 출력")
    void testInputCarName(){
        String input = "pobi, woni, jun";

        List<Car> cars = new RacingGame().inputCarName(input);

        assertThat(cars.size()).isEqualTo(3);
        assertThat(cars.get(0).getName()).isEqualTo("pobi");
        assertThat(cars.get(1).getName()).isEqualTo("woni");
        assertThat(cars.get(2).getName()).isEqualTo("jun");

    }

}