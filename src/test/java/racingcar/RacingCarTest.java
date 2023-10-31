package racingcar;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.input.CarListTest.CarList;
import racingcar.input.CarTest.Car;
import racingcar.input.RacingCountTest.RacingCount;
import racingcar.CheckMoveAndStopTest.CheckMoveAndStop;
import racingcar.output.WinnerTest.Winner;

public class RacingCarTest {
    private final static String 차량이름들 = "pobi1,pobi2,pobi3,pobi4";
    private final static String 사용자_이동_횟수 = "10";

    static class RacingCar{
        public static void play(){
            List<Car> cars = CarList.inputCarList(차량이름들).getCarList();
            int raceCount = RacingCount.inputRaceCount(사용자_이동_횟수).getRaceCount();

            CheckMoveAndStop checkMoveAndStop = CheckMoveAndStop.run(cars, raceCount);
            int maxDistance = checkMoveAndStop.getMaxDistance();

            Winner winner = Winner.inputWinner(cars, maxDistance);
            winner.printWinner();
        }
    }

    @Test
    void startGame(){
        RacingCar.play();
    }
}
