package racingcar.controller;

import org.junit.jupiter.api.Test;
import racingcar.model.Racer;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class WinnerDeciderTest {

    @Test
    void 우승자_제대로_리턴하는지_확인() {
        // Given
        List<Racer> racers = new ArrayList<>();
        Racer racer1 = new Racer("racer1");
        Racer racer2 = new Racer("racer2");
        Racer racer3 = new Racer("racer3");

        // When
        racer1.goState();
        racer1.goState();
        racer2.goState();
        racer3.goState();
        racer3.goState();
        racer3.goState();
        racers.add(racer1);
        racers.add(racer2);
        racers.add(racer3);

        // Then
        assertThat(WinnerDecider.getWinner(racers)).isEqualTo("racer3");
    }
}