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
        List<String> result = Display.inputCars();
        List<String> target = Arrays.asList("영희","철수");
        assertThat(result).isEqualTo(target);
    }
}
