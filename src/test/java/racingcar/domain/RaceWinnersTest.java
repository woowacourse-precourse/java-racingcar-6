package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.FakeNumberGenerator;


@DisplayName("RaceWinners 클래스")
class RaceWinnersTest {

    @Test
    @DisplayName("우승자가 한 명인 경우")
    void raceWinnerOneTest() {
        RaceParticipants raceParticipants = new RaceParticipants("Car1, Car2, Car3", new FakeNumberGenerator(7));
        RacingCar car1 = raceParticipants.getRacingCarList().get(0);

        car1.moveOrStop();

        RaceWinners winners = RaceWinners.from(raceParticipants);
        List<String> winnersList = winners.getWinners();

        assertEquals(1, winnersList.size());
        assertEquals(List.of("Car1"), winnersList);
    }

    @Test
    @DisplayName("우승자가 여러 명인 경우")
    void raceWinnersMultipleTest() {
        RaceParticipants raceParticipants = new RaceParticipants("Car1, Car2, Car3", new FakeNumberGenerator(7));
        RacingCar car1 = raceParticipants.getRacingCarList().get(0);
        RacingCar car2 = raceParticipants.getRacingCarList().get(1);

        car1.moveOrStop();
        car2.moveOrStop();

        RaceWinners winners = RaceWinners.from(raceParticipants);
        List<String> winnersList = winners.getWinners();

        assertEquals(2, winnersList.size());
        assertEquals(List.of("Car1", "Car2"), winnersList);
    }
}
