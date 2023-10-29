package racingcar.controller;

import java.util.List;
import racingcar.controller.dto.GameResultDto;
import racingcar.domain.Car;

public class GameService {

    public GameService() {
    }

    public String getGameWinner(List<Car> winnerCars) {
        GameResultDto gameResultDto = new GameResultDto(winnerCars);
        return gameResultDto.convertOutput();
    }
}