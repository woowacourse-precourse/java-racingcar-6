package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.function.Supplier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    private Cars cars;
    private int ONE = 1;

    @BeforeEach
    void init() {
        cars = Cars.makeCars(List.of("ONE", "TWO"));
    }

    @Test
    @DisplayName("Cars 에서 moveCarAndGetResult 메서드에 true 를 넣으면 자동차가 한 칸씩 이동한 결과 메시지를 얻는다.")
    void CarsTest_MoveTrue() {
        String moveResult = cars.moveCarAndGetResult(() -> true);
        assertThat(moveResult).isEqualTo("ONE : -\nTWO : -\n");
    }

    @Test
    @DisplayName("Cars 에서 moveCarAndGetResult 메서드에 false 를 넣으면 자동차가 이동하지 않은 결과 메시지를 얻는다.")
    void CarsTest_MoveFalse() {
        String moveResult = cars.moveCarAndGetResult(() -> false);
        assertThat(moveResult).isEqualTo("ONE : \nTWO : \n");
    }

    @Test
    @DisplayName("Cars 에서 moveCarAndGetResult 메서드에 false, true 를 차례대로 한번만 넣으면 우승자는 TWO 가 된다.")
    void CarsTest_Winner() {
        cars.moveCarAndGetResult(booleanSupplier());
        assertThat(cars.getWinner()).contains("TWO");
    }

    private Supplier<Boolean> booleanSupplier() {
        return () -> ((ONE++) % 2) == 0;
    }

}