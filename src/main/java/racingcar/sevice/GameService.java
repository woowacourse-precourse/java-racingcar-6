package racingcar.sevice;

import java.util.ArrayList;
import java.util.List;
import racingcar.controller.dto.GameResultDto;
import racingcar.controller.dto.RoundResponseDto;
import racingcar.domain.Car;
import racingcar.manager.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

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
        for (Car car : carList) {
            if (topPosition < car.getPosition()) {
                winnerCars.clear();
                topPosition = car.getPosition();
            }
            if (topPosition == car.getPosition()) {
                winnerCars.add(car);
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

    public void runRound(int gameRound, List<Car> carList) {
        for (int i = 0; i < gameRound; i++) {
            for (Car tempCar : carList) {
                tempCar.move();
            }
            OutputView.printGameStatus(new RoundResponseDto(carList));
        }
    }
}