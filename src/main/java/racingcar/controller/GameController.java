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
        //시도 횟수만큼 각 Car에 랜덤 넘버로 움직인 후
        for(int i = 0; i < tryCount; i++){
            carList.forEach(car -> car.moveOrStop(randomNUmberGenerator.generate()));
        }
    }
}
