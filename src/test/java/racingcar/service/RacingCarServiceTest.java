package racingcar.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.controller.RacingGame;
import racingcar.domain.RacingCar;
import racingcar.util.TestNumberGenerator;

class RacingCarServiceTest {
    private static RacingCarService racingCarService;

    @BeforeAll
    static void setUp(){
        racingCarService = new RacingCarService(new TestNumberGenerator(4));
    }

    @Test
    @DisplayName("RacingCar 객체가 정상적으로 생성되는지 테스트")
    void saveRacingCarTest(){
        String[] carNames = {"a", "b", "c"};

        List<RacingCar> racingCars = racingCarService.save(carNames);

        assertEquals(carNames[0], racingCars.get(0).toString());
        assertEquals(carNames[1], racingCars.get(1).toString());
        assertEquals(carNames[2], racingCars.get(2).toString());
    }

    @Test
    @DisplayName("우승자가 정상적으로 결정되는지 테스트")
    void decideWinnerTest(){
        RacingCar racingCar01 = new RacingCar("a");
        RacingCar racingCar02 = new RacingCar("b");
        List<RacingCar> racingCars = Arrays.asList(racingCar01, racingCar02);

        racingCar01.increaseMoveNumber();

        List<RacingCar> winners = racingCarService.getWinner(racingCars);

        assertEquals(1, winners.size());
        assertEquals(racingCar01, winners.get(0));
    }

    @Test
    @DisplayName("우승자가 2명 이상 정상적으로 결정되는지 테스트")
    void decideWinnersTest(){
        RacingCar racingCar01 = new RacingCar("a");
        RacingCar racingCar02 = new RacingCar("b");
        RacingCar racingCar03 = new RacingCar("c");
        RacingCar racingCar04 = new RacingCar("d");

        List<RacingCar> racingCars = Arrays.asList(racingCar01, racingCar02, racingCar03, racingCar04);

        racingCar01.increaseMoveNumber();
        racingCar02.increaseMoveNumber();

        List<RacingCar> winners = racingCarService.getWinner(racingCars);

        assertEquals(2, winners.size());
        assertEquals(racingCar01, winners.get(0));
        assertEquals(racingCar02, winners.get(1));
    }
}