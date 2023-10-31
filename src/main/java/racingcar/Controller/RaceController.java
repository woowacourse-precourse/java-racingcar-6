package racingcar.Controller;

import racingcar.Model.Car;
import racingcar.Service.InputValidation;
import racingcar.Service.RaceService;
import racingcar.View.InputView;
import racingcar.View.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RaceController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    RaceService raceService = new RaceService();
    List<Car> racingCars;

    public void RaceGamePlay() {
        startGameSet();
        int count = playCount();
        System.out.println("");
        System.out.println("실행 결과");

        for (int i = 0; i < count; i++) {
            playRace();
            outputView.result(racingCars);
        }
        String winner = raceService.winnerResult(racingCars);
        outputView.winner(winner);
    }

    private void playRace() {
        for (Car car : racingCars) {
            if (raceService.RandomNum() >= 4) {
                car.setLocation(car.getLocation() + 1);
            }
        }
    }

    private int playCount() {
        return inputView.playCount();
    }

    private void startGameSet() {
        String input = inputView.carName();

        List<String> carNames = raceService.carNameStringToList(input);
        racingCars = new ArrayList<>();

        for (String carName : carNames) {
            racingCars.add(new Car(carName, 0));
        }
    }
}
