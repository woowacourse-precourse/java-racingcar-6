package racingcar;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;
import racingcar.model.Car;

public class CarModelTest {
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"", " ", "5자초과한이름"})
    void 이름이_5를_초과할_때_예외를_던진다(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Car(input));
    }

    @Nested
    class 전진_정지 {
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
}
