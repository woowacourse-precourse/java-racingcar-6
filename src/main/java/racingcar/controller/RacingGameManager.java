package racingcar.controller;

import java.util.List;
import racingcar.View.InputView;
import racingcar.View.OutputView;
import racingcar.model.Car;
import racingcar.model.Cars;

public class RacingGameManager {
    private Cars cars;
    private InputView inputView;
    private OutputView outputView;

    public RacingGameManager() {
    }

    public RacingGameManager(Cars cars, InputView inputView, OutputView outputView) {
        this.cars = cars;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void gameStart(){
        String names = inputView.enterCarNames();
        cars.setCarList(names);

        String inputTryCount = inputView.enterTryCount();
        tryCountValidation(inputTryCount);
        int tryCount = convertStringToInt(inputTryCount);

        System.out.println("실행 결과");
        repeatMove(tryCount);

        List<Car> winner = cars.getWinner();
        outputView.printWinner(cars.winnerToString(winner));
    }

    void repeatMove(int tryCount){
        while (tryCount > 0){
            cars.moveCars();

            outputView.printProgressStatus(cars.getProgressStatus());
            tryCount--;
        }
    }

    void tryCountValidation(String tryCount){
        if(!isNumeric(tryCount)){
            throw new IllegalArgumentException();
        }
        if(Integer.parseInt(tryCount) < 1){
            throw new IllegalArgumentException();
        }
    }

    private int convertStringToInt(String tryCount){
        return Integer.parseInt(tryCount);
    }

    private boolean isNumeric(String inputString) {
        return inputString.matches("-?\\d+");  // 정수만 허용
    }
}
