package racingcar;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import static racingcar.Car.moreThanOneWinner;


public class ViewTest {
    @Test
    void 우승자가_여려명일때_출력_처리(){
        List<String> input = new ArrayList<>();
        input.add("pobi");
        input.add("jun");
        assertThat(moreThanOneWinner(input)).isEqualTo("pobi, jun");
    }
}
