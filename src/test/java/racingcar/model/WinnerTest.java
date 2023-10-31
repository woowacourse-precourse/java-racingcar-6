package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.dto.WinnerResult;

public class WinnerTest {

    private Winner winner;
    private Cars cars;
    private List<Car> carList;

    @BeforeEach
    void setup() {
        cars = new Cars("pobi,woni,jun");
        carList = cars.getCars();

        carList.get(0).run(4);
        carList.get(2).run(4);

        winner = new Winner(cars);
    }

    @Test
    void 선두_위치_확인_테스트() {
        int lead = 1;
        assertThat(winner.getLead(carList)).isEqualTo(lead);
    }

    @Test
    void 우승자_명단_확인_테스트() {
        String expectedWinnerNames = "pobi, jun";

        WinnerResult winnerResult = new WinnerResult(winner);
        String actualWinnerNames = String.join(", ",
                winnerResult.getWinners());

        assertThat(actualWinnerNames).isEqualTo(expectedWinnerNames);
    }
}