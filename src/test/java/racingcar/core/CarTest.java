package racingcar.core;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mockStatic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import racingcar.util.RandomNumber;

public class CarTest {
    @Test
    void car_생성자_테스트() {
        String name = "pobyy";
        Car car = new Car(name);
        assertThat(car.getName()).isEqualTo(name);
    }

    @Test
    void car_생성자_이름_null_대입시_예외_반환() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Car(null);
        });
    }

    @Test
    void car_생성자_이름_길이_5_초과시_예외_반환() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Car("abcdefg");
        });
    }

    @Test
    void car_생성자_이름_길이_0_이하시_예외_반환() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Car("");
        });
    }

    @Test
    void car_생성자_이름_공백시_예외_반환() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Car("   ");
        });
    }

    @Test
    void move_메서드는_4이상의_수에서_움직임_테스트() {
        Car car = new Car("pobi");
        try (final MockedStatic<RandomNumber> mock = mockStatic(RandomNumber.class)) {
            mock.when(RandomNumber::generateSingleDigit).thenReturn(4);
            car.move();
        }
        assertThat(car.getForwardCount()).isGreaterThan(0);
        assertThat(car.getTrialCount()).isGreaterThan(0);
    }

    @Test
    void move_메서드는_4미만의_수에서_움직이지_않음_테스트() {
        Car car = new Car("pobi");
        try (final MockedStatic<RandomNumber> mock = mockStatic(RandomNumber.class)) {
            mock.when(RandomNumber::generateSingleDigit).thenReturn(3);
            car.move();
        }
        assertThat(car.getForwardCount()).isEqualTo(0);
        assertThat(car.getTrialCount()).isGreaterThan(0);
    }

    @Test
    void getCurrentStatusString_메서드는_차가_움직일_경우_언더스코어_추가_테스트() {
        Car car = new Car("pobi");
        try (final MockedStatic<RandomNumber> mock = mockStatic(RandomNumber.class)) {
            mock.when(RandomNumber::generateSingleDigit).thenReturn(5);
            car.move();
        }
        assertThat(car.getCurrentStatusString()).contains("pobi", "-");
    }

    @Test
    void getCurrentStatusString_메서드는_차가_움직이지_않을_경우_언더스코어_없음_테스트() {
        Car car = new Car("pobi");
        try (final MockedStatic<RandomNumber> mock = mockStatic(RandomNumber.class)) {
            mock.when(RandomNumber::generateSingleDigit).thenReturn(2);
            car.move();
        }
        assertThat(car.getCurrentStatusString()).contains("pobi");
        assertThat(car.getCurrentStatusString()).doesNotContain("-");
    }
}
