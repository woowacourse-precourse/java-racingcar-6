package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class WinnersTest {

    @Test
    void 우승자_명단_출력_테스트() {
        List<String> winnersName = List.of("pobi", "jun");
        Winners winners = new Winners(winnersName);

        String result = "pobi, jun";

        assertEquals(winners.getWinnersName(), result);
    }

}