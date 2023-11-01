package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    public void 새로_생성된_차의_위치는_0이여야_한다() {
        Car car = new Car("MyCar");
        assertEquals(0, car.getPosition());
    }


    @Test
    public void 이름이_5자를_초과할_경우_에러가_발생한다() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Car("YourCar");
        });
        assertEquals("이름은 5자 이하로 입력해야 합니다.", exception.getMessage());
    }

    @Test
    public void 공백만_입력할_경우_에러가_발생한다() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Car(" ");
        });
        assertEquals("공백만 입력할 수는 없습니다.", exception.getMessage());
    }
}

