package racingcar.controller;

import racingcar.model.Car;
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
        outputView.printCarNameInputMessage();
        List<Car> carList = transferUtil.transferStringToListCar(inputView.readCarNames());
        outputView.printTryCountInputMessage();
        int tryCount = inputView.readTryCount();
        outputView.printNewLine();
        outputView.printPlayingResult();
        //시도 횟수만큼 반복
        for(int i = 0; i < tryCount; i++){
            playingGame(carList);
        }
    }

    private void playingGame(List<Car> carList) {
        //CarList의 각 Car에서 random수를 이용해 전진 후 OutputView로 이름과 현재 위치를 출력
        carList.forEach(car -> {
            car.moveOrStop(randomNUmberGenerator.generate());
            outputView.printCarNameAndPosition(car.provideCarNameAndPositionState());
        });
        outputView.printNewLine();
    }
}
