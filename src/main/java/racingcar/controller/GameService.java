package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.controller.dto.GameResultDto;
import racingcar.domain.Car;

public class GameService {

    public GameService() {
    }

    public List<Car> registerCarListFromInput(String[] input) {
        List<Car> carList = new ArrayList<>();
        for (String s : input) {
            Car car = new Car(s);
            carList.add(car);
        }
        return carList;
    }


    public String getGameWinner(List<Car> winnerCars) {
        GameResultDto gameResultDto = new GameResultDto(winnerCars);
        return gameResultDto.convertOutput();
    }
}