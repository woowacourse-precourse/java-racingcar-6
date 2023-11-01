package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerCheckerTest {

    @DisplayName("[WinnerChecker] 우승자 뽑아내기 테스트")
    @Test
    void 우승자_뽑아내기_테스트() {
        // Given
        WinnerChecker winnerChecker = new WinnerChecker();

        Car car1 = new Car("woo");
        car1.setDistance(1);
        Car car2 = new Car("wa");
        car2.setDistance(3);
        Car car3 = new Car("6");
        car3.setDistance(4);

        List<Car> carList = List.of(car1, car2, car3);
        // When
        List<String> winners = winnerChecker.checkWinner(carList);
        // Then
        assertThat(winners).isEqualTo(List.of("6"));
    }

}