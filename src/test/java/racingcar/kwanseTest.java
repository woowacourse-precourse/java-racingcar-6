package racingcar;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.ExceptionHandler.run_ExceptionHandler;
import static racingcar.Input.carNames;
import static racingcar.Winner.whoIsTheWinner;

public class kwanseTest {

    @Test
    void 우승자가_여러명이면_쉼표로_구분() {
        List<Car> cars = new ArrayList<>();
        cars.add(0, new Car("pobi"));
        cars.add(1, new Car("khan"));

        cars.get(0).setCount(1);
        cars.get(1).setCount(1);

        assertThat(whoIsTheWinner(cars))
                .isEqualTo("pobi, khan");
    }

    @Test
    void 다섯글자_넘으면_예외() {
        carNames.add(0, "abcdef");
        assertThatThrownBy(() -> run_ExceptionHandler())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름이_중복되면_예외() {
        carNames.add(0, "pobi");
        carNames.add(1, "pobi");

        assertThatThrownBy(() -> run_ExceptionHandler())
                .isInstanceOf(IllegalArgumentException.class);
    }
}
