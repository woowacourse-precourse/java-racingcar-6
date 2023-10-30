package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import domain.Cars;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OutputTest {
    @Test
    @DisplayName("MoveCount 결과 일치 비교")
    void correct_move_count_check() {
        Cars cars = new Cars("a,b");
        List<Integer> moveCountLists = new ArrayList<>();

        cars.getCarsList().forEach(car -> {
            car.moveOrStop(4);
        });

        cars.getCarsList().forEach(car -> {
            moveCountLists.add(car.getMoveCount());
        });

        assertThat(moveCountLists).containsOnly(1, 1);
    }

    @Test
    @DisplayName("Winner 일치 확인")
    void correct_winners_check() {
        Cars cars = new Cars("a,b");

        cars.getCarsList().forEach(car -> {
            car.moveOrStop(4);
        });

        List<String> winners = cars.getWinners();
        List<String> expectedWinners = Arrays.asList("a", "b");

        // Winners 의 인덱스 목록이 같은지 확인
        assertThat(winners).isEqualTo(expectedWinners);
    }
}
