package racingcar.Service;

import org.junit.jupiter.api.Test;
import racingcar.Controller.GameController;
import racingcar.Domain.Car;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @Test
    void 입력된_자동차_이름을_저장하는_자동차객체_리스트를_생성한다(){
        String input = "apple,banana,kiwi";

        RacingGame rg = new RacingGame(input);
        List<Car> cars = rg.getCars();
        assertThat(cars).extracting("name").contains("apple","banana","kiwi");
    }

}
