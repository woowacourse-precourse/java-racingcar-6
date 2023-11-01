package racingcar.domain.round;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;

class RoundResultTest {

    Car[] cars = new Car[]{new Car("a"), new Car("b")};
    RoundResult roundResult = new RoundResult(cars);

    @Test
    @DisplayName("라운드 결과 TEST")
    void getRoundResult() {
        String answer = "a : \n" + "b : \n";
        System.out.println(roundResult.getRoundResult());
        assertThat(answer).isEqualTo(roundResult.getRoundResult());
    }

    @Test
    @DisplayName("라운드 결과 Log TEST")
    void getMileageResult() {
        int[] intArray = {1, 2, 3, 4, 5};
        String[] moveLogArray = {"-", "--", "---", "----", "-----"};
        for (int i = 0; i < 5; i++) {
            assertThat(roundResult.getMileageResult(intArray[i]))
                .isEqualTo(moveLogArray[i]);
        }
    }

    @Test
    @DisplayName("모든 라운드 종료후 최댓값 TEST")
    void getMaxMoveCount() {
        roundResult.getMileageResult(1);
        roundResult.getMileageResult(5);
        assertThat(roundResult.getMaxMoveCount()).isEqualTo(5);
    }
}