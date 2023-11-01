package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameRecordTest {

    GameRecord gameRecord;

    @BeforeEach
    void init() {
        gameRecord = new GameRecord();
    }

    @Test
    @DisplayName("단독 우승자")
    void soloWinner() {

        // Given
        List<Car> recordList = new ArrayList<>();
        recordList.add(new Car("pobi", 4));
        recordList.add(new Car("jun", 8));
        recordList.add(new Car("woni", 6));

        // When
        List<String> winner = gameRecord.findWinner(recordList);

        // Then
        assertThat(String.join(", ", winner)).isEqualTo("jun");
    }

    @Test
    @DisplayName("공동 우승자")
    void shareWinner() {

        // Given
        List<Car> recordList = new ArrayList<>();
        recordList.add(new Car("pobi", 4));
        recordList.add(new Car("jun", 8));
        recordList.add(new Car("sangwoo", 8));
        recordList.add(new Car("woni", 6));

        // When
        List<String> winner = gameRecord.findWinner(recordList);

        // Then
        assertThat(String.join(", ", winner)).isEqualTo("jun, sangwoo");
    }
}