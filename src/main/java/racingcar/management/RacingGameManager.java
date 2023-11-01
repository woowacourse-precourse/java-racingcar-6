package racingcar.management;

import java.util.List;
import racingcar.car.Car;
import racingcar.carlist.RacingCarList;
import racingcar.numbergeneration.MoveNumberGenerator;
import racingcar.print.EachRoundResultPrinter;
import racingcar.user.User;

public class RacingGameManager {
    private final RacingCarList racingCarList;
    private final int MAX_ROUND;

    public RacingGameManager(User user, RacingCarList racingCarList) {
        this.racingCarList = racingCarList;
        this.MAX_ROUND = user.getInputRacingRound();
    }
    public void runRace() {
        List<Car> racingCarsList = racingCarList.getRacingCarList();

        for (int startRound = 0; startRound < MAX_ROUND; startRound++) {
            runOneRound(racingCarsList);
            EachRoundResultPrinter.printEachRoundResult(racingCarsList);
        }
    }

    private void runOneRound(List<Car> racingCarsList) {
        racingCarsList.forEach(car -> {
            int numberToMove = MoveNumberGenerator.generateNumber();
            car.move(numberToMove);
        });

    }
}
