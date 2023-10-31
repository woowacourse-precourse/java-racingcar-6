package racingcar;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class DisplayTest {

    @Test
    void 인풋을_리스트로_반환_테스트() {
        System.setIn(new ByteArrayInputStream("영희,철수".getBytes()));
        List<Car> result = Display.inputCars();
        List<Car> target = Arrays.asList(new Car("영희"),new Car("철수"));
        assertThat(result).isEqualTo(target);
    }
}
