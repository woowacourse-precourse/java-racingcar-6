package racingcar.model;

import static racingcar.config.Settings.CAR_AMOUNT;

public class RacingGame {
    private final CarManager manager;

    public RacingGame(CarManager manager) {
        this.manager = manager;
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

    public String playRound() {
        StringBuilder roundResult = new StringBuilder();
        for (int index = 0; index < CAR_AMOUNT; index++) {
            Car car = manager.getCarFromIndex(index);

            car.tryMove();
            roundResult.append(car.getPosition());
        }

        return roundResult.toString();
    }

    private void cutStringTail(StringBuilder winners) {
        int length = winners.length();
        winners.delete(length - 2, length);
    }

}
