package racingcar.dto;

import java.util.List;
import racingcar.domain.car.Car;

public class GameResultDto {

    private boolean isSingleWinner;
    private List<Car> winners;

    public GameResultDto(List<Car> winners) {
        isSingleWinner = winners.size() == 1;
        this.winners = winners;
    }

    public boolean isSingleWinner() {
        return isSingleWinner;
    }

    public List<Car> getWinners() {
        return winners;
    }

    public Car getSingleWinner() {
        return winners.get(0);
    }

}
