package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import racingcar.input.Car;
import racingcar.input.CarList;
import racingcar.input.RacingCount;
import racingcar.output.Winner;

public class RacingCar {
    public static void play(){
        List<Car> cars = CarList.inputCarList(readLine()).getCarList();
        int raceCount = RacingCount.inputRaceCount(readLine()).getRaceCount();

        CheckMoveAndStop checkMoveAndStop = CheckMoveAndStop.run(cars, raceCount);
        int maxDistance = checkMoveAndStop.getMaxDistance();

        Winner winner = Winner.inputWinner(cars, maxDistance);
        winner.printWinner();
    }
}
