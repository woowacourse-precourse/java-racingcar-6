package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.GameResult;
import racingcar.model.dto.CarStatusDto;
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

    public void start() {
        Cars cars = new Cars(transferUtil.transferStringToListString(printInputCarNames()));
        int tryCount = printInputTryCount();
        printEmptyLine();

        playingGame(cars, tryCount);
        endGame(cars);
    }


    private void playingGame(Cars cars, int tryCount) {
        //자동차 전진 or 스탑 후 각 자동차의 상태 출력 (시도 횟수 만큼 반복)
        for(int i = 0; i < tryCount; i++) {
            cars.eachCarMoveOrStop();
            List<CarStatusDto> carStatusDtos = cars.printCarsStatus();
            carStatusDtos.forEach(carStatusDto -> printCarNameAndPosition(carStatusDto));
            printEmptyLine();
        }
    }

    private void endGame(Cars cars) {
        int winPosition = cars.findCarsMaxPosition();
        GameResult gameResult = new GameResult(cars, winPosition);
        printWinner(gameResult.printWinCarsStatus());
    }

    private String printInputCarNames() {
        outputView.printCarNameInputMessage();
        return inputView.readCarNames();
    }

    private int printInputTryCount() {
        outputView.printTryCountInputMessage();
        return inputView.readTryCount();
    }

    private void printEmptyLine() {
        outputView.printNewLine();
    }

    private void printCarNameAndPosition(CarStatusDto carStatusDto) {
        outputView.printCarNameAndPosition(transferUtil.transferCarStatusDtoToNameAndPosition(carStatusDto));
    }

    private void printWinner(List<CarStatusDto> carStatusDtos) {
        outputView.printWinnerMessage(transferUtil.transferCarStatusDtoToNameJoining(carStatusDtos));
    }
}
