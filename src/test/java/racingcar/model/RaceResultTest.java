package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RaceResultTest {

    @DisplayName("우승자 발표 테스트")
    @Test
    void announce_winner() {
        List<String> names = List.of("a", "b", "c");
        List<Integer> positions = List.of(1, 4, 4);
        Circuit circuit = new Circuit(IntStream.range(0, names.size())
                .boxed()
                .collect(Collectors.toMap(names::get, positions::get)));
        assertEquals("b, c", circuit.report().toString());
    }
}
