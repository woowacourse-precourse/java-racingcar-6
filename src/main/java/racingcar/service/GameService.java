package racingcar.service;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.gameInfo.InputManager;
import racingcar.domain.Movable;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.view.OutputView;

public class GameService {
    private static Cars cars;

    public static void racingStart(InputManager inputManager) {
        int round = inputProcessing(inputManager);
        progressRound(round);
        OutputView.gameStartMessage();
    }

    public static int inputProcessing(InputManager inputManager){
        List<Car> parsedCarList = inputManager.getParsedCarList();
        cars = new Cars(parsedCarList);
        return inputManager.getGameProcessCount();
    }

    public static void progressRound(int round){
        for (int i = 0; i < round; i++) {
            cars.oneRoundProgress(new Movable());
            OutputView.oneTurnResult(cars);
        }
    }

    public static String chooseWinner(){
        List<Car> winnerList = cars.getWinners();
        return winnerList.stream()
                .map(Car:: getName)
                .collect(Collectors.joining(", "));
    }

}
