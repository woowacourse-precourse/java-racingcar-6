package racingcar.Service;

import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import racingcar.Domain.Car;
import racingcar.Domain.Race;

class RacingCarServiceTest extends NsTest {

    private RacingCarService racingCarService;

    @BeforeEach
    void setUp() {
        racingCarService = new RacingCarService();
    }

    @Test
    void 우승자_선정() {
        Car car1 = new Car("pobi");
        Car car2 = new Car("mini");
        Race race = new Race(List.of(car1, car2), 0);

        car1.carMove(5);
        car2.carMove(3);

        List<String> winners = racingCarService.selectWinners(race);

        assertTrue(winners.contains("pobi"));
    }

    @Test
    void 동점_우승자_확인(){
        Car car1 = new Car("pobi");
        Car car2 = new Car("mini");
        Race race = new Race(List.of(car1, car2), 0);

        car1.carMove(4);
        car2.carMove(4);

        List<String> winners = racingCarService.selectWinners(race);

        assertTrue(winners.contains("pobi"));
        assertTrue(winners.contains("mini"));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}