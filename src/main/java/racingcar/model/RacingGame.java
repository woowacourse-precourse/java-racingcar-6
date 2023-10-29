package racingcar.model;

import static racingcar.config.Settings.CAR_AMOUNT;

import racingcar.domain.Car;
import racingcar.dto.CarDTO;

public class RacingGame {
    private final CarManager manager;

    public RacingGame(CarManager manager) {
        this.manager = manager;
    }

    public String getWinners() {
        StringBuilder winners = new StringBuilder();
        int farthest = manager.getFarthestMove();

        for (int index = 0; index < CAR_AMOUNT; index++) {
            Car car = manager.getCarFromIndex(index);
            CarDTO dto = car.toDTO();

            if (dto.getPosition() == farthest) {
                winners.append(dto.getName());
                winners.append(", ");
            }
        }
        removeWinnersStringTail(winners);

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


    // 문자열 생성 과정에서 생긴 불필요한 부분 제거
    private void removeWinnersStringTail(StringBuilder winners) {
        int REMOVE_FROM = winners.length() - 2;
        int REMOVE_TO = winners.length();

        winners.delete(REMOVE_FROM, REMOVE_TO);
    }

}
