package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.models.Car;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RefereeTest {

    private Referee referee = new Referee();

    private List<String> getSampleCarNames() {
        return List.of("pobi", "crong", "honux");
    }

    @BeforeEach
    void 심판_초기화() {
        referee = new Referee();
    }

    @Test
    void 자동차_추가() {
        // given
        List<String> carNames = getSampleCarNames();

        // when
        referee.addCars(carNames);

        // then
        assertEquals(3, referee.getCars().size());
    }

    @Test
    void 게임_진행상황_저장() {
        // given
        List<String> carNames = getSampleCarNames();
        referee.addCars(carNames);

        // when
        referee.startGame(5);

        // then
        assertEquals(5, referee.getGameStatuses().size());
    }

    @Test
    void 우승자_인원수_체크() {
        // given
        List<String> carNames = getSampleCarNames();
        referee.addCars(carNames);

        // when
        referee.startGame(5);

        // then
        int maxDistance = referee.getCars().stream()
                .mapToInt(Car::getMoveDistance)
                .max().orElseThrow();

        int winnerCount = (int) referee.getCars().stream()
                .filter(car -> car.isWinner(maxDistance)).count();

        assertEquals(winnerCount, referee.getWinners().size());
    }

}