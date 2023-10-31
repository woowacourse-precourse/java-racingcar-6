package racingcar.controller;

import org.junit.jupiter.api.Test;
import racingcar.model.Racer;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RacerManagerTest {

    @Test
    void 쉼표_기준으로_이름_분리_확인() {
        // Given
        String input = "pobi,woni,jun";

        // When
        RacerManager racerManager = new RacerManager();
        List<String> result = racerManager.seperateRacersName(input);

        // Then
        assertThat(result).isEqualTo(List.of("pobi", "woni", "jun"));
    }

    @Test
    void Racer_객체_생성_기능_확인() {
        // Given
        List<String> racerNames = List.of("Racer1", "Racer2", "Racer3");

        // When
        List<Racer> racers = RacerManager.createRacers(racerNames);

        // Then
        assertThat(racers.get(0).getName()).isEqualTo("Racer1");
        assertThat(racers.get(1).getName()).isEqualTo("Racer2");
        assertThat(racers.get(2).getName()).isEqualTo("Racer3");
    }
}