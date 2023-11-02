package racingcar.management;

import java.util.ArrayList;
import java.util.List;
import racingcar.car.Car;
import racingcar.carlist.RacingCarList;
import racingcar.util.print.numbergeneration.MoveNumberGenerator;
import racingcar.util.print.EachRoundResultPrinter;
import racingcar.util.print.supervisor.RacingGameSupervisor;
import racingcar.user.User;
import racingcar.util.print.WinnerPrinter;

public class RacingGameManager {
    private final RacingCarList racingCarList;
    private final int MAX_ROUND;
    private List<Car> winner;

    public RacingGameManager(User user, RacingCarList racingCarList) {
        this.racingCarList = racingCarList;
        this.MAX_ROUND = user.getInputRacingRound();
        this.winner = new ArrayList<>();
    }
    public void runRace() {
        racingCarList.addNewRacingCar();

        List<Car> racingCarsList = racingCarList.getRacingCarList();

        for (int startRound = 0; startRound < MAX_ROUND; startRound++) {
            runOneRound(racingCarsList);
            EachRoundResultPrinter.printEachRoundResult(racingCarsList);
        }
        winner = RacingGameSupervisor.decideWinner(racingCarsList);
        WinnerPrinter.printRacingWinner(winner);

    }

    private void runOneRound(List<Car> racingCarsList) {
        racingCarsList.forEach(car -> {
            int numberToMove = MoveNumberGenerator.generateNumber();
            car.move(numberToMove);
        });

    }
}
