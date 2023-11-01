package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import racingcar.model.Car;

public class CarMoveTest {
    private static MockedStatic<Randoms> randoms;
    private Car car;

    @BeforeEach
    void init() {
        randoms = mockStatic(Randoms.class);
        car = new Car("car1");
    }

    @AfterEach
    void close() {
        randoms.close();
    }

    @Test
    void 랜덤_숫자가_4이상일_때_전진() {
        when(Randoms.pickNumberInRange(0, 9)).thenReturn(4);
        car.move();

        assertThat(car.getNameWithPosition()).contains("car1 : -");
    }

    @Test
    void 랜덤_숫자가_4보다_작을_때_정지() {
        when(Randoms.pickNumberInRange(0, 9)).thenReturn(1);
        car.move();

        assertThat(car.getNameWithPosition()).contains("car1 : ");
    }
}
