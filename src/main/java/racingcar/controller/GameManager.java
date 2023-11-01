package racingcar.controller;
import racingcar.domain.Car;
import racingcar.service.GameProgressService;
import racingcar.service.GameResultService;
import racingcar.view.GameOutput;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private final UserInputHandler userInputHandler = new UserInputHandler();
    private final GameProgressService gameProgressService = new GameProgressService();
    private final GameResultService gameResultService = new GameResultService();


    public void start() {
        try
        {
            List<String> nameList = userInputHandler.getCarNameList();
            int round = userInputHandler.getGameRound();
            List<Car> carList = createCarList(nameList);
            startGame(round, carList);
            getFinalWinner(carList);
        }
        catch (Exception ex) {
            GameOutput.printErrorMessage(ex.getMessage());
        }
    }

    public List<Car> createCarList (List<String> nameList) {
        List<Car> carList = new ArrayList<Car>();
        for(String name: nameList) {
            Car car = new Car(name);
            carList.add(car);
        }
        return carList;
    }

    private void startGame(int round, List<Car> carList) {
        GameOutput.printGameStart();
        for(int i=0; i< round; i++) {
            startRound(carList);
        }
    }
    private void startRound(List<Car> carList) {
        gameProgressService.moveCars(carList);
        String roundResult = gameProgressService.getRoundResults(carList);
        GameOutput.printRoundResult(roundResult);
    }

    private void getFinalWinner(List<Car> carList) {
        String result = gameResultService.getFinalWinners(carList);
        GameOutput.printFinalWinner(result);
    }
}
