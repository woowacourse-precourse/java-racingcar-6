package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.application.RandomMoveRule;
import racingcar.domain.policy.MoveRule;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CarsTest {
    private static final int MIN_RANGE = 0;
    private static final int MAX_RANGE = 9;

    @Test
    @DisplayName("Cars는 정상적으로 생성되어야 한다.")
    void Cars_정상_생성() {
        Car first = new Car("First");
        Car Secon = new Car("Secon");

        Cars cars = new Cars(List.of(first, Secon));

        assertNotNull(cars);
        assertEquals(
                """
                        First :\s
                        Secon :\s
                        """
                , cars.printPosition());
    }

    @Test
    @DisplayName("Cars의 move는 정상적으로 작동되어야 한다. 2개 다 전진")
    void Cars_move_정상작동_2개다_전진() {
        MoveRule moveRule = mock(RandomMoveRule.class);
        when(moveRule.generateValue(MIN_RANGE, MAX_RANGE)).thenReturn(4, 4);

        Car first = new Car("First");
        Car Secon = new Car("Secon");

        Cars cars = new Cars(List.of(first, Secon));
        cars.move(moveRule);

        assertNotNull(cars);
        assertEquals(
                """
                        First : -
                        Secon : -
                        """
                , cars.printPosition());
    }

    @Test
    @DisplayName("Cars의 move는 정상적으로 작동되어야 한다. 1개만 전진")
    void Cars_move_정상작동_1개만_전진() {
        MoveRule moveRule = mock(RandomMoveRule.class);
        when(moveRule.generateValue(MIN_RANGE, MAX_RANGE)).thenReturn(5, 2);

        Car first = new Car("First");
        Car Secon = new Car("Secon");

        Cars cars = new Cars(List.of(first, Secon));
        cars.move(moveRule);

        assertNotNull(cars);
        assertEquals(
                """
                        First : -
                        Secon :\s
                        """
                , cars.printPosition());
    }

    @Test
    @DisplayName("Cars의 move는 정상적으로 작동되어야 한다. 전진 못함")
    void Cars_move_정상작동_전진_못함() {
        MoveRule moveRule = mock(RandomMoveRule.class);
        when(moveRule.generateValue(MIN_RANGE, MAX_RANGE)).thenReturn(2, 2);

        Car first = new Car("First");
        Car Secon = new Car("Secon");

        Cars cars = new Cars(List.of(first, Secon));
        cars.move(moveRule);

        assertNotNull(cars);
        assertEquals(
                """
                        First :\s
                        Secon :\s
                        """
                , cars.printPosition());
    }

    @Test
    @DisplayName("Cars의 getWinner은 승자를 반환해줘야 한다.")
    void Cars_getWinner_승자_반환() {
        MoveRule moveRule = mock(RandomMoveRule.class);
        when(moveRule.generateValue(MIN_RANGE, MAX_RANGE)).thenReturn(5, 2);

        Car first = new Car("First");
        Car Secon = new Car("Secon");

        Cars cars = new Cars(List.of(first, Secon));
        cars.move(moveRule);
        String winner = cars.getWinner();

        assertNotNull(cars);
        assertEquals("First", winner);
    }

    @Test
    @DisplayName("Cars의 getWinner은 승자가 중복된 경우 모두 출력해줘야 한다.")
    void Cars_getWinner_중복된_승자_모두_반환() {
        MoveRule moveRule = mock(RandomMoveRule.class);
        when(moveRule.generateValue(MIN_RANGE, MAX_RANGE)).thenReturn(5, 5);

        Car first = new Car("First");
        Car Secon = new Car("Secon");

        Cars cars = new Cars(List.of(first, Secon));
        cars.move(moveRule);
        String winner = cars.getWinner();

        assertNotNull(cars);
        assertEquals("First, Secon", winner);
    }

    @Test
    @DisplayName("Cars의 getWinner은 둘 다 진행하지 못한 경우에도 모두 출력")
    void Cars_getWinner_진행못해도_중복된_승자_모두_반환() {
        MoveRule moveRule = mock(RandomMoveRule.class);
        when(moveRule.generateValue(MIN_RANGE, MAX_RANGE)).thenReturn(2, 2);

        Car first = new Car("First");
        Car Secon = new Car("Secon");

        Cars cars = new Cars(List.of(first, Secon));
        cars.move(moveRule);
        String winner = cars.getWinner();

        assertNotNull(cars);
        assertEquals("First, Secon", winner);
    }
}