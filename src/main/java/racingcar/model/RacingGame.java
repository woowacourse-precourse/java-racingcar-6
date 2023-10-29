package racingcar.model;

import static racingcar.model.Settings.ATTEMPT_MAX;
import static racingcar.model.Settings.CAR_AMOUNT;

public class RacingGame {
    private final CarManager manager;

    public RacingGame(CarManager manager) {
        this.manager = manager;
    }

    public void playGame() {
        int round = 0;
        do {
            proceedRound();
            round++;
        } while (round < ATTEMPT_MAX);
    }

    private void proceedRound() {
        for (int index = 0; index < CAR_AMOUNT; index++) {
            Car car = manager.getCarFromIndex(index);

            car.tryMove();
            car.getPosition();
        }
        System.out.println();
    }

    public String getWinners() {
        StringBuilder winners = new StringBuilder();
        int biggest = manager.getBiggestMove();

        for (int index = 0; index < CAR_AMOUNT; index++) {
            Car car = manager.getCarFromIndex(index);

            if (car.getMoves() == biggest) {
                winners.append(car.getName());
                winners.append(", ");
            }
        }
        cutStringTail(winners);
        return winners.toString();
    }

    private void cutStringTail(StringBuilder winners) {
        int length = winners.length();
        winners.delete(length - 2, length);
    }

}
