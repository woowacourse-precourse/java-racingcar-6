package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.GameResult;
import racingcar.util.NumberGenrator;
import racingcar.util.RandomNumberGenrator;
import racingcar.util.TransferUtil;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class GameController {
    private final static InputView inputView = new InputView();
    private final static OutputView outputView = new OutputView();
    private final static TransferUtil transferUtil = new TransferUtil();
    private final static NumberGenrator randomNUmberGenerator = new RandomNumberGenrator();

    public void start() {
        startRace();
        outputView.printNewLine();
        outputView.printPlayingResult();
        //시도 횟수만큼 반복
        for(int i = 0; i < tryCount; i++){
            playingRace(carList);
        }
        GameResult gameResult = endGame(carList);
        outputView.printWinnerMessage(gameResult.provideWinnderCarName());
    }

    private void startRace() {
        outputView.printCarNameInputMessage();
        Cars cars = new Cars(transferUtil.transferStringToListString(inputView.readCarNames()));
        outputView.printTryCountInputMessage();
        int tryCount = inputView.readTryCount();
    }

    private void playingRace(List<Car> carList) {
        //CarList의 각 Car에서 random수를 이용해 전진 후 OutputView로 이름과 현재 위치를 출력
        carList.forEach(car -> {
            car.moveOrStop(randomNUmberGenerator.generate());
            outputView.printCarNameAndPosition(car.provideCarNameAndPositionState());
        });
        outputView.printNewLine();
    }

    private GameResult endGame(List<Car> carList) {
        int winPosition = 0;
        for(Car car : carList){
            winPosition = Math.max(car.getPosition(), winPosition);
        }
        GameResult gameResult = new GameResult(winPosition);
        gameResult.addCarList(carList);
        return gameResult;
    }
}
