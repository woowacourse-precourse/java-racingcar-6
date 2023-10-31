package racingcar.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.domain.Cars;
import racingcar.domain.Winner;
import racingcar.exception.InputException;
import racingcar.service.GameService;
import racingcar.view.ResultOutput;
import racingcar.view.UserInput;

public class GameController {

    private static final String START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String EXECUTIONRESULT_MESSAGE = "실행 결과";
    private static final String ATTEMPTS_MESSAGE = "시도할 회수는 몇회인가요?";
    private UserInput userInput = new UserInput();
    private Cars cars = new Cars();
    private GameService gameService = new GameService();
    private ResultOutput resultOutput = new ResultOutput();
    private ArrayList<String> finalWinnerList = new ArrayList<>();
    private InputException inputException = new InputException();
    private Winner winner = new Winner();
    private int attemptsCount;

    public void start() {

        System.out.println(START_MESSAGE);
        String carNames = userInput.readUserInput();
        cars.setCarNameList(spiltCarNames(carNames));
        inputException.checkCarNamesInputException(spiltCarNames(carNames));

        System.out.println(ATTEMPTS_MESSAGE);
        attemptsCount = Integer.parseInt(userInput.readAttemptsCount());
        inputException.checkAttemptsInputException(attemptsCount);

        initializeCarProgress();

        startRacing(attemptsCount, cars.getCarNameList(), cars.getCarProgress());
        findWinner(cars.getCarNameList(), cars.getCarProgress());
        resultOutput.printFinalWinner(winner.getWinnerList());

    }

    private void startRacing(int attemptsCount, ArrayList<String> carNameList, ArrayList<List<String>> carProgress) {
        System.out.println();
        System.out.println(EXECUTIONRESULT_MESSAGE);

        for (int i = 0; i < attemptsCount; i++) {

            cars.setCarProgress(gameService.moveCar(carNameList, carProgress));

            resultOutput.printExecutionResult(cars.getCarNameList(), cars.getCarProgress());
        }
    }

    private void findWinner(ArrayList<String> carNameList, ArrayList<List<String>> carProgress) {
        finalWinnerList = winner.getFinalWinner(carNameList, carProgress);
        winner.setWinnerList(finalWinnerList);
    }


    private ArrayList<String> spiltCarNames(String carNames) {
        String[] spiltedCarNames = carNames.split(",");
        ArrayList<String> spiltedCarNameList = new ArrayList<>(Arrays.asList(spiltedCarNames));

        return spiltedCarNameList;
    }

    public void initializeCarProgress() {
        ArrayList<List<String>> progress = cars.getCarProgress();

        for (int i = 0; i < cars.getCarNameList().size(); i++) {
            List<String> car = new ArrayList<>();
            car.add("");
            progress.add(car);
        }

        cars.setCarProgress(progress);
    }

}
