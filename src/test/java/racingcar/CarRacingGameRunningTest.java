package racingcar;

import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRacingGameRunningTest {

    @Test
    void checkCarMovingRule_ShouldPrintCarNameWhenCarMovesForward() {
        // 자동차가 전진할 때 해당 자동차의 이름이 출력되는지 확인하는 테스트
        Car car = new Car("pobi");
        car.moveForward();
        assertThat(car.getName()).isEqualTo("pobi");
    }

    @Test
    void determineWinner_ShouldReturnCarWithMaximumDistance() {
        // 가장 멀리 간 자동차가 승자로 결정되는지 확인하는 테스트
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        car1.moveForward();
        car1.moveForward();
        car2.moveForward();

        CarRacingGame game = new CarRacingGame(Arrays.asList(car1, car2));
        assertThat(game.determineWinners()).containsExactly(car1);
    }

    @Test
    void displayGameResults_ShouldShowWinnerOrWinners() {
        // 승자 또는 승자들을 표시하는지 확인하는 테스트
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        car1.moveForward();
        car1.moveForward();
        car2.moveForward();

        CarRacingGame game = new CarRacingGame(Arrays.asList(car1, car2));
        assertThat(game.determineWinners()).containsExactly(car1);
    }

}
