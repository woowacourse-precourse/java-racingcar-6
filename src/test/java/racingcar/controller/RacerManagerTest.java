package racingcar.controller;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RacerManagerTest {

    @Test
    void 쉼표_기준으로_이름_분리_확인() {
        // Given
        String input = "pobi,woni,jun";

        // When
        RacerManager racerManager = new RacerManager();
        List<String> result = racerManager.seperateCarName(input);

        // Then
        assertThat(result).isEqualTo(List.of("pobi", "woni", "jun"));
    }
}