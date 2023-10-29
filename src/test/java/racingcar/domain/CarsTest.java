package racingcar.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarsTest {

    private final Name POBI = new Name("pobi");
    private final Name WONI = new Name("woni");
    private final Name ANOTHER_POBI = new Name("pobi");

    @Test
    public void 이름_중복_테스트() {
        // given
        final List<Car> cars = List.of(new Car(POBI), new Car(WONI), new Car(ANOTHER_POBI));

        // then
        Assertions.assertThatThrownBy(() -> new Cars(cars))
                .isInstanceOf(IllegalArgumentException.class);
    }
}