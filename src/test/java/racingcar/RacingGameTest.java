package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

class RacingGameTest {
    @Test
    void generateCarList_입력값에_알맞은_객체_리스트_리턴() {
        RacingGame racingGame = new RacingGame();
        String input = "pobi,jigi,test";
        List<String> carList = List.of("pobi", "jigi", "test");
        List<String> result = new ArrayList<>();
        for (Car car : racingGame.generateCarList(input)) {
            result.add(car.name);
        }
        assertEquals(result, carList);
    }
}