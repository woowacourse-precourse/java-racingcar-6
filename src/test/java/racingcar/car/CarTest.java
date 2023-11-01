package racingcar.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.validator.InputValidator;

public class CarTest {

    @Test
    public void 자동차_전진_조건_부합() throws Exception{
        // given
        Car car = new Car("brian");

        // when
        car.moveForward(4);
        car.moveForward(5);

        // then
        assertThat(car.getPosition()).isEqualTo(2);
    }

    @Test
    public void 자동차_전진_조건_미달() throws Exception{
        // given
        Car car = new Car("brian");

        // when
        car.moveForward(2);
        car.moveForward(3);

        // then
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    public void 유효한_숫자_검증() throws Exception{
        String input = "a";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validateNumbers(input);
        });
    }

    @Test
    public void 중복_이름_검증() throws Exception{
        String[] names = {"brian", "poby", "brian"};
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validateDuplicateName(names);
        });
    }

    @Test
    public void 유효한_이름_검증() throws Exception{
        String[] names = {"brian", "poby", "yoo~!"};
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validateName(names);
        });
    }

    @Test
    public void 유효한_이름_길이_검증() throws Exception{
        String[] names = {"brian", "poby", "andres"};
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validateNameLength(names);
        });
    }

    @Test
    public void 연이은_쉼표_검증() throws Exception{
        String alignedNames = "brian,poby,,jake";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validateConsecutiveCommas(alignedNames);
        });
    }
}
