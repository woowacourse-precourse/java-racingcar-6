package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingGameTest {
    @DisplayName("콘솔에서 이름 입력부터 Name 생성까지 통합 기능.")
    @Test
    void inputCarNames_이름입력_통합() {
        RacingGame racingGame = new RacingGame();
        String names = "pobi,woni,jun,james,timmy,ski";
        String[] splitName = names.split(",");

        List<Car> cars = racingGame.inputCarNames(names);

        for (int index = 0; index < cars.size(); index++) {
            assertThat(cars.get(index).getNameValue()).isEqualTo(splitName[index]);
        }
    }
}
