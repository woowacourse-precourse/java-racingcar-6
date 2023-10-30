package racingcar.sevice;

import java.util.ArrayList;
import java.util.List;
import racingcar.controller.dto.GameResultDto;
import racingcar.domain.Car;
import racingcar.manager.Validator;
import racingcar.view.InputView;

public class GameService {

    Validator validator;

    public GameService(Validator validator) {
        this.validator = validator;
    }

    public List<Car> registerCarListFromInput(String[] input) {
        validator.validateCarNamesDuplicated(input);
        List<Car> carList = new ArrayList<>();
        for (String s : input) {
            validator.validateCarName(s);
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
            }
            if (topPosition == tempCar.getPosition()) {
                winnerCars.add(tempCar);
            }
        }
        return winnerCars;
    }

    public String getGameWinner(List<Car> winnerCars) {
        GameResultDto gameResultDto = new GameResultDto(winnerCars);
        return gameResultDto.convertOutput();
    }

    public int getGameRound() {
        String round = InputView.inputGameRound();
        return validator.validateGameRound(round);
    }
}