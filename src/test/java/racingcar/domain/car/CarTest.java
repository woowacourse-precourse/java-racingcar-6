package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.policy.DriveRule;
import racingcar.application.RandomDriveRule;

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
    }

    @Test
    @DisplayName("Car의 이름이 5글자를 넘으면 오류가 발생한다.")
    void Car_Name_6글자_이상이면_익셉션_발생() {
        assertThrows(IllegalArgumentException.class, () -> new Car("abcdef"));
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("Car은 5 이상의 값이 나오면 전진 할 수 있어야 한다.")
    void Car은_정상적으로_전진한다(int value) {
        DriveRule driveRule = mock(RandomDriveRule.class);
        when(driveRule.generateValue(MIN_RANGE, MAX_RANGE)).thenReturn(value);

        Car car = new Car("test");
        car.move(driveRule);
        String position = car.printPosition();

        assertEquals("test : -", position);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("Car은 2회 전진할 수 있어야 한다.")
    void Car은_정상적으로_전진한다_2회() {
        DriveRule driveRule = mock(RandomDriveRule.class);
        when(driveRule.generateValue(MIN_RANGE, MAX_RANGE)).thenReturn(5);

        Car car = new Car("test");
        car.move(driveRule);
        car.move(driveRule);
        String position = car.printPosition();

        assertEquals("test : --", position);
    }

    @Test
    @DisplayName("Car은 4 미만의 값이 나오면 전진 할 수 없다.")
    void Car은_전진하지_못한다() {
        DriveRule driveRule = mock(RandomDriveRule.class);
        when(driveRule.generateValue(MIN_RANGE, MAX_RANGE)).thenReturn(3);

        Car car = new Car("test");
        car.move(driveRule);
        String position = car.printPosition();

        assertEquals("test : ", position);
    }
}