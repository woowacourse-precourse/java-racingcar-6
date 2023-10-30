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
    private int tryCount;

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
        setTryCount(inputTryCount);

        System.out.println("실행 결과");
        repeatMove(tryCount);

        List<Car> winner = cars.getWinner();
        outputView.printWinner(winner);
    }

    void repeatMove(int tryCount){
        while (tryCount > 0){
            cars.moveCars();
            outputView.printProgressStatus(cars.getCarList());
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
    private void setTryCount(String tryCount){
        tryCountValidation(tryCount);
        this.tryCount = convertStringToInt(tryCount);
    }

    private int convertStringToInt(String tryCount){
        return Integer.parseInt(tryCount);
    }

    private boolean isNumeric(String inputString) {
        return inputString.matches("-?\\d+");
    }
}
