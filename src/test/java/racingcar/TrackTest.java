package racingcar;

import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TrackTest {

    private Track track;
    private ArrayList<RacingCar> cars;

    @BeforeEach
    void initTrack() {
        track = new Track();
        cars = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            cars.add(new RacingCar("racing " + (i + 1)));
        }
    }

    @Test
    void 경주를_진행한다() {
        Map roundResult = track.round(cars);
        Assertions.assertEquals(roundResult.size(), cars.size());
    }

    @ParameterizedTest
    @MethodSource("roundMoveInfoProvider")
    void 어차피_우승자는_racing1이다(List<List<Integer>> list) {
        List<Integer> round = list.get(0);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < cars.size(); j++) {
                cars.get(j).moveBy(round.get(j));
            }
        }

        List<String> selectedWinners = track.selectWinners(cars);
        Assertions.assertEquals("racing 1", selectedWinners.get(0));
    }

    @Test
    void 너랑_나랑_공동우승이다() {
        cars.forEach(racingCar -> racingCar.moveBy(5));
        List<String> selectedWinners = track.selectWinners(cars);
        for (int i = 0; i < selectedWinners.size(); i++) {
            Assertions.assertEquals(cars.get(i).getName(), selectedWinners.get(i));
        }
    }

    static Stream<Arguments> roundMoveInfoProvider() {
        return Stream.of(
                arguments(List.of(
                        List.of(5, 1, 1, 1, 1),
                        List.of(5, 1, 1, 1, 1),
                        List.of(5, 1, 1, 1, 1),
                        List.of(5, 1, 1, 1, 1),
                        List.of(5, 1, 1, 1, 1)))
        );
    }
}