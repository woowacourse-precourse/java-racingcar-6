package racingcar;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class InputTest {

    private static final Input input = new Input();

    @Test
    void 자동차_객체_리스트_생성() {

        //given
        String carsName = "pobi,woni,jun";
        System.setIn(new ByteArrayInputStream(carsName.getBytes()));

        //when
        List<Car> cars = input.getCars();

        //then
        assertThat(cars.size()).isEqualTo(3);
        assertThat(cars.get(0).getName()).isEqualTo("pobi");
        assertThat(cars.get(1).getName()).isEqualTo("woni");
        assertThat(cars.get(2).getName()).isEqualTo("jun");
        for (int i = 0; i < cars.size(); i++) {
            assertThat(cars.get(i).getMove()).isEqualTo(0);
        }
    }
}
