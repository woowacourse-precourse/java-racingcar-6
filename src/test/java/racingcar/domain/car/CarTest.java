package racingcar.domain.car;

import exception.WrongNameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.policy.MoveRule;
import racingcar.application.RandomMoveRule;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CarTest {
    private static final int MIN_RANGE = 0;
    private static final int MAX_RANGE = 9;

    @Test
    @DisplayName("Car은 정상적으로 생성 되어야 한다.")
    void Car_정상_생성_테스트() {
        Car car = new Car("test");

        assertNotNull(car);
        assertNotEquals(0, car.hashCode());
    }

    @Test
    @DisplayName("Car의 이름이 5글자를 넘으면 오류가 발생한다.")
    void Car_Name_6글자_이상이면_익셉션_발생() {
        assertThrows(WrongNameException.class, () -> new Car("abcdef"));
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("Car은 5 이상의 값이 나오면 전진 할 수 있어야 한다.")
    void Car은_정상적으로_전진한다(int value) {
        MoveRule moveRule = mock(RandomMoveRule.class);
        when(moveRule.generateValue(MIN_RANGE, MAX_RANGE)).thenReturn(value);

        Car car = new Car("test");
        car.move(moveRule);
        String position = car.printPosition();

        assertEquals("test : -\n", position);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("Car은 2회 전진할 수 있어야 한다.")
    void Car은_정상적으로_전진한다_2회() {
        MoveRule moveRule = mock(RandomMoveRule.class);
        when(moveRule.generateValue(MIN_RANGE, MAX_RANGE)).thenReturn(5);

        Car car = new Car("test");
        car.move(moveRule);
        car.move(moveRule);
        String position = car.printPosition();

        assertEquals("test : --\n", position);
    }

    @Test
    @DisplayName("Car은 4 미만의 값이 나오면 전진 할 수 없다.")
    void Car은_전진하지_못한다() {
        MoveRule moveRule = mock(RandomMoveRule.class);
        when(moveRule.generateValue(MIN_RANGE, MAX_RANGE)).thenReturn(3);

        Car car = new Car("test");
        car.move(moveRule);
        String position = car.printPosition();

        assertEquals("test : \n", position);
    }

    @Test
    @DisplayName("Car이 승자일 경우 이름을 반환해줘야 한다.")
    void Car가_승자일_경우_이름을_반환() {
        MoveRule moveRule = mock(RandomMoveRule.class);
        when(moveRule.generateValue(MIN_RANGE, MAX_RANGE)).thenReturn(5, 2);

        Car first = new Car("First");
        Car secon = new Car("Secon");
        first.move(moveRule);
        secon.move(moveRule);

        String winner = first.getWinner(List.of(first, secon));

        assertEquals("First", winner);
    }

    @Test
    @DisplayName("Car이 승자가 아닐 경우 이름을 반환하면 안된다.")
    void Car가_승자일_경우_빈문자열_반환() {
        MoveRule moveRule = mock(RandomMoveRule.class);
        when(moveRule.generateValue(MIN_RANGE, MAX_RANGE)).thenReturn(2, 5);

        Car first = new Car("First");
        Car secon = new Car("Secon");
        first.move(moveRule);
        secon.move(moveRule);

        String winner = first.getWinner(List.of(first, secon));

        assertEquals("", winner);
    }
}