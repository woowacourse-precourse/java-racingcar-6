package racingcar.sevice;

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

    public List<Car> extractWinner(List<Car> carList) {
        List<Car> winnerCars = new ArrayList<>();
        int topPosition = -1;
        for (int i = 0; i < carList.size(); i++) {
            Car tempCar = carList.get(i);
            if (topPosition < tempCar.getPosition()) {
                winnerCars.clear();
                topPosition = tempCar.getPosition();
                winnerCars.add(tempCar);
            } else if (topPosition == tempCar.getPosition()){
                winnerCars.add(tempCar);
            }
        }
        return winnerCars;
    }

    public String getGameWinner(List<Car> winnerCars) {
        GameResultDto gameResultDto = new GameResultDto(winnerCars);
        return gameResultDto.convertOutput();
    }
}