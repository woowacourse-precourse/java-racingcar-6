package racingcar;

import racingcar.controller.WinnersAnnouncer;
import racingcar.model.RacingCar;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class WinnersAnnouncerTest {

    @Test
    public void announceWinners_ShouldReturnWinningCarNames_WhenMultipleCarsHaveSameMaxPosition() {
        WinnersAnnouncer announcer = new WinnersAnnouncer();

        RacingCar car1 = new RacingCar("Car1");
        RacingCar car2 = new RacingCar("Car2");
        RacingCar car3 = new RacingCar("Car3");
        car1.move(3);
        car2.move(4);
        car3.move(4);
        RacingCar[] cars = {car1, car2, car3};

        String winners = announcer.announceWinners(cars);
        assertThat(winners).isEqualTo("Car2, Car3");
    }
}
