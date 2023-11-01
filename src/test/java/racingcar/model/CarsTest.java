package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.generator.RandomNumberOverFour;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("[CarsTest]")
public class CarsTest {
    @Test
    @DisplayName("Cars 생성 테스트")
    void createCarsTest() {
        // Given
        List<Car> carList = List.of(
                new Car("pobi"),
                new Car("woni"),
                new Car("jun"));
        String InputCarNames = "pobi,woni,jun";

        // When
        Cars cars = new Cars(InputCarNames);

        // Then
        for (int i = 0; i < carList.size(); i++) {
            assertThat(carList.get(i).getName()).isEqualTo(cars.getCars().get(i).getName());
        }
    }

    @Test
    @DisplayName("자동차 경주 게임의 승자를 리턴하는 테스트")
    void sendRacingGameWinnerTest() {
        // Given
        List<String> winners = List.of("jun");
        Cars cars = new Cars("pobi,jun");
        List<Car> carList = cars.getCars();
        carList.get(1).canIMove(new RandomNumberOverFour());

        // When
        List<String> winnersNameList = cars.sendRacingGameWinner();

        // Then
        assertThat(winnersNameList).isEqualTo(winners);
    }
}
