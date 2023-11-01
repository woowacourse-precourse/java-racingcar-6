package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class RefereeTest {

    @Test
    void 우승자_판단() {
        Car pobi = Car.createFromName("pobi");
        Car woni = Car.createFromName("woni");
        Car jun = Car.createFromName("jun");
        CarManager carManager = CarManager.createFromCars(List.of(pobi, woni, jun));
        Referee referee = new Referee();

        pobi.moveForward(4);
        woni.moveForward(4);
        jun.moveForward(3);
        carManager.updateMaxMoveForwardCount(1);

        List<String> winners = referee.determineWinners(carManager);
        assertThat(winners.size()).isEqualTo(2);
        assertThat(winners).containsExactly("pobi", "woni");
    }


}