package racingcar;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.input.CarListTest.CarList;
import racingcar.input.CarTest.Car;
import racingcar.input.RacingCountTest.RacingCount;
import racingcar.CheckMoveAndStopTest.CheckMoveAndStop;
import racingcar.input.WinnerTest.Winner;

public class RacingCarTest {
    private static String 차이름들 = "";
    private final static String 경주_횟수 = "10";

    private void 차이름_n개_입력하라(int count) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < count; i++) {
            sb.append(i).append(",");
        }

        차이름들 = sb.toString();
    }

    static class RacingCar {
        public static void play() {
            List<Car> cars = CarList.inputCarList(차이름들).getCarList();
            int raceCount = RacingCount.inputRaceCount(경주_횟수).getRaceCount();

            CheckMoveAndStop checkMoveAndStop = CheckMoveAndStop.run(cars, raceCount);
            int maxDistance = checkMoveAndStop.getMaxDistance();

            Winner winner = Winner.inputWinner(cars, maxDistance);
            winner.printWinner();
        }
    }

    @Test
    void 테스트_최대_범위() {
        차이름_n개_입력하라(10);

        RacingCar.play();
    }
}
