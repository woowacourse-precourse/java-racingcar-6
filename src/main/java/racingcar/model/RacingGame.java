package racingcar.model;

import static racingcar.model.Settings.ATTEMPT_MAX;
import static racingcar.model.Settings.CAR_AMOUNT;

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

    public void playRace() {
        int round = 0;
        do {
            playRound();
            round++;
        } while (round < ATTEMPT_MAX);
    }

    // TODO: 처리결과 View로 넘기기(직접출력 x)
    private void playRound() {
        for (int index = 0; index < CAR_AMOUNT; index++) {
            Car car = manager.getCarFromIndex(index);

            car.tryMove();
            car.getPosition();
        }
        System.out.println();
    }

    private void cutStringTail(StringBuilder winners) {
        int length = winners.length();
        winners.delete(length - 2, length);
    }

}
